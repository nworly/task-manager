package ru.netology.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Client {

    public static void main(String[] args) throws IOException {
        try (
                Socket socket = new Socket("localhost", 8989);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {

            out.println("{ \"type\": \"ADD\", \"task\": \"View reports on the work of managers" + "\" }");
            System.out.println(in.readLine());

            out.println("{ \"type\": \"ADD\", \"task\": \"Check the sales plan" + "\" }");
            System.out.println(in.readLine());

            out.println("{ \"type\": \"ADD\", \"task\": \"Check the contract with Luxoft" + "\" }");
            System.out.println(in.readLine());

            out.println("{ \"type\": \"ADD\", \"task\": \"Listen to call recordings" + "\" }");
            System.out.println(in.readLine());

            out.println("{ \"type\": \"ADD\", \"task\": \"Hold a meeting with managers" + "\" }");
            System.out.println(in.readLine());

            out.println("{ \"type\": \"REMOVE\", \"task\": \"Check the sales plan" + "\" }");
            System.out.println(in.readLine());

            out.println("{ \"type\": \"REMOVE\", \"task\": \"Check the contract with Luxoft" + "\" }");
            System.out.println(in.readLine());

        }
    }
}
