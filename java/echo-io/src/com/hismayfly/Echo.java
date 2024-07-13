package com.hismayfly;

import com.hismayfly.Blocking.BlockingClient;
import com.hismayfly.Blocking.BlockingServer;

public class Echo {
    public static void main(String[] args) {
        Thread serverThread = new Thread(new BlockingServer());
        Thread clientThread = new Thread(new BlockingClient());
        serverThread.start();
        clientThread.start();

        System.out.println("done");
    }
}
