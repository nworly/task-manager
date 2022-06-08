package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {

    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        List<String> sorted = tasks.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        for (String task : sorted) {
            sb.append(task).append(" ");
        }

        return sb.toString();
    }

    public int getTasksAmount() {
        return tasks.size();
    }
}
