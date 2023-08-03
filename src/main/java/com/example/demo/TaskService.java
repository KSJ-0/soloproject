package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    //TaskRepository DI
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    public Task readTask(long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }
    public List<Task> readTasks() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }
    public Task updateTask(Task task) {

        return taskRepository.save(task);
    }
    public void deleteTask(long memberId) {
        taskRepository.deleteById(memberId);
    }
    public void deleteTasks() {

        taskRepository.deleteAll();
    }
}
