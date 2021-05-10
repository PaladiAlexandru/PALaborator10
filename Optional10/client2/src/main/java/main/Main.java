package main;

import client.MyClient;

public class Main {
    public static void main(String[] args) {
        MyClient client = new MyClient();
        client.connect();
    }
}
