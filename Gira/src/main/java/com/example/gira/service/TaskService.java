package com.example.gira.service;

import com.example.gira.model.entity.Task;
import com.example.gira.model.service.TaskServiceAddModel;

import java.util.List;

public interface TaskService {

    TaskServiceAddModel addTask(TaskServiceAddModel taskServiceAddModel);

    List<Task> getAllTasks();

    void changeProgress(Long id);
}
