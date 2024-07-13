package com.hismayfly.Blocking;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class BlockingClient implements Runnable {
    private static final String POISON_PILL = "BYE";

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void run()  {
        try {
            final var socket = new Socket();
            socket.connect(new InetSocketAddress(8888));

            final Thread readerThread = new Thread(new ReaderTask());
            readerThread.setDaemon(true);
            readerThread.start();

            final var writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            final var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            for (var msg = queue.take(); !Thread.interrupted(); msg = queue.take()) {
                System.out.println("===> " + msg);

                writer.write(msg);
                writer.newLine();
                writer.flush();

                final var response = reader.readLine();
                System.out.println("<=== " + response);

                if (response.equals(POISON_PILL)) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private class ReaderTask implements Runnable {
        @Override
        public void run() {
            try (final var userReader = new BufferedReader(new InputStreamReader(System.in))) {
                for (var line = userReader.readLine(); line != null; line = userReader.readLine()) {
                    queue.put(line);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
