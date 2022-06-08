package ru.netology.javacore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    Todos todos;

    @BeforeEach
    public void setup() {
        todos = new Todos();
    }

    @Test
    @DisplayName("Should Add Task")
    void shouldAddTask() {
        String task1 = "View reports on the work of managers";
        String task2 = "Listen to call recordings";
        String task3 = "Check a sales plan";

        todos.addTask(task1);
        todos.addTask(task2);
        todos.addTask(task3);

        assertFalse(todos.getAllTasks().isEmpty());
        assertEquals(3, todos.getTasksAmount());
    }

    @Test
    @DisplayName("Should Be Empty After Removing Tasks")
    void shouldRemoveTask() {
        String task1 = "View reports on the work of managers";
        String task2 = "Listen to call recordings";
        String task3 = "Check a sales plan";

        todos.addTask(task1);
        todos.addTask(task2);
        todos.addTask(task3);
        todos.removeTask(task1);
        todos.removeTask(task2);
        todos.removeTask(task3);

        assertTrue(todos.getAllTasks().isEmpty());
    }

    @Test
    @DisplayName("Should Get All Tasks")
    void shouldGetAllTasks() {
        String task1 = "View reports on the work of managers";
        String task2 = "Listen to call recordings";
        String task3 = "Check a sales plan";

        String output = "Check a sales plan Listen to call recordings View reports on the work of managers ";

        todos.addTask(task1);
        todos.addTask(task2);
        todos.addTask(task3);

        assertEquals(output, todos.getAllTasks());
    }
}