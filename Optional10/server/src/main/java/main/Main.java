package main;

import server.MyServer;

public class Main {
    public static void main(String[] args) {
        MyServer server = new MyServer();
        server.startServer();
    }
}
