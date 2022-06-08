package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() {
        System.out.println("Starting server at " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            while (true) {

                try (
                        Socket clientSocket = serverSocket.accept();
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    String jsonTask;

                    while ((jsonTask = in.readLine()) != null) {

                        TaskOperation operation = gson.fromJson(jsonTask, TaskOperation.class);

                        String type = operation.type;
                        String task = operation.task;

                        if ("ADD".equals(type)) {
                            todos.addTask(task);
                        } else if ("REMOVE".equals(type)) {
                            todos.removeTask(task);
                        } else {
                            throw new RuntimeException("Incorrect data");
                        }

                        out.println(todos.getAllTasks());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setTodos(Todos todos) {
        this.todos = todos;
    }
}
