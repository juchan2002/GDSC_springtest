package com.example.GDSC_Backend.controller;

import com.example.GDSC_Backend.model.Task;
import com.example.GDSC_Backend.repository.TaskRepository;
import com.example.GDSC_Backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = new TaskService();
    }

    @PostMapping
    @ResponseBody
    public Task createTask(@RequestParam String title, @RequestParam String description, @RequestParam LocalDate dueDate, @RequestParam boolean status) {
        return taskService.createTask(title, description, dueDate, status);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Task getTask(@PathVariable Long id) {
        Optional<Task> task = taskService.getTask(id);
        return task.orElse(null);
    }

    @GetMapping
    @ResponseBody
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Task updateTask(@PathVariable Long id, @RequestParam String title, @RequestParam String description, @RequestParam LocalDate dueDate, @RequestParam boolean status) {
        return taskService.updateTask(id, title, description, dueDate, status);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
