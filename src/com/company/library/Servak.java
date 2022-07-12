package com.company.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servak {
    public static void main(String[] args) {

        int port = 8085;

        try (ServerSocket serv = new ServerSocket(port);
             Socket servSoket = serv.accept();
             PrintWriter out = new PrintWriter(servSoket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(servSoket.getInputStream()))) {

            System.out.println("СЕРВЕР СОЗДАН. Ждет входящих запросов...");

            String inputMess1 = in.readLine();
            System.out.println("Получено входящее сообщение: " + inputMess1);

            out.println("Ты - " + inputMess1 + ", порт номер " + servSoket.getPort());
            System.out.println("Ответ послан...");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
