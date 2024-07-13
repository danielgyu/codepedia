package com.hismayfly.Blocking;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockingServer implements Runnable{
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));

            while (true) {
                System.out.println("accepting...");
                final Socket acceptedSocket = serverSocket.accept();
                new SocketHandler(acceptedSocket).run();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static class SocketHandler implements Runnable {
        private final Socket socket;

        public SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (final Socket ignored = socket;
                 final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    System.out.println("<===" + line);

                    writer.write(line);
                    writer.newLine();
                    writer.flush();

                    System.out.println("===>" + line);

                    if (line.equals("BYE")) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("closing socket" + socket + ": " + socket.isClosed());
            }
        }
    }
}
