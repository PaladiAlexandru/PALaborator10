package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {

    public void connect() {
        boolean running = true;
        String serverAddress = "127.0.0.1";
        int PORT = 8100;

        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {
            // Send a request to the server
            while (running) {
                Scanner sc = new Scanner(System.in);
                String request = sc.nextLine();
                if (request.equals("exit") || request.equals("stop"))
                    running = false;

                out.println(request);
                // Wait the response from the server
                String response = in.readLine();
                System.out.println(response);
            }


        }catch (SocketException e){
            System.err.println("You are out!");
        }
        catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

