package com.company.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 8085;

        try (Socket client1 = new Socket(host, port);
             PrintWriter out = new PrintWriter(client1.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client1.getInputStream()))
        ) {

            out.println("ClientSay");

            String responceServ = in.readLine();
            System.out.println("Server responding: " + responceServ);


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
