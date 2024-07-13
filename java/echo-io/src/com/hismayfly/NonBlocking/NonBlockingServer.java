package com.hismayfly.NonBlocking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NonBlockingServer {
    public void nonBlockingHandle(Selector selector) throws IOException {
        for (final Iterator<SelectionKey> iterator = selector.selectedKeys().iterator(); iterator.hasNext(); iterator.remove()) {
            final SelectionKey key = iterator.next();
            if (key.isAcceptable()) {
                final ServerSocketChannel server = (ServerSocketChannel) key.channel();
                final SocketChannel client = server.accept();
                client.configureBlocking(false);
                client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, ByteBuffer.allocate(1024));
                System.out.println("client = " + client);
            }
            if (key.isReadable()) {
                System.out.println("is readable");
            }
            if (key.isWritable()) {
                System.out.println("is writable");
            }
        }
    }
    public void run() {
        try (final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            final Selector selector = Selector.open();

            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                if (selector.select(1000L) == 0) {
                    continue;
                }

                nonBlockingHandle(selector);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
