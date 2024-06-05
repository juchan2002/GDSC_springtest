package com.example.GDSC_Backend.repository;

import com.example.GDSC_Backend.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private AtomicLong nextId = new AtomicLong(1);

    public Task save(Task task){
        if (task.getId() == null){
            task.setId(nextId.getAndIncrement());
        }
        tasks.add(task);
        return task;
    }

    public Optional<Task> findById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    public void deleteById(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}
