package com.example.gira.service.impl;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.Task;
import com.example.gira.model.entity.User;
import com.example.gira.model.entity.enums.ProgressEnum;
import com.example.gira.model.service.TaskServiceAddModel;
import com.example.gira.repository.TaskRepository;
import com.example.gira.service.ClassificationService;
import com.example.gira.service.TaskService;
import com.example.gira.service.UserService;
import com.example.gira.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ClassificationService classificationService;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, ClassificationService classificationService) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.classificationService = classificationService;
    }

    @Override
    public TaskServiceAddModel addTask(TaskServiceAddModel taskServiceAddModel) {
        Task task = modelMapper.map(taskServiceAddModel, Task.class);

        User user = userService.findUserById(currentUser.getId());
        Classification classification = classificationService.findByEnum(taskServiceAddModel.getClassification());

        task.setUser(user);
        task.setClassification(classification);
        task.setProgress(ProgressEnum.OPEN);

        return modelMapper.map(taskRepository.save(task), TaskServiceAddModel.class);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void changeProgress(Long id) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task != null) {

            if (task.getProgress() == ProgressEnum.COMPLETED) {
                taskRepository.delete(task);

            } else {
                switch (task.getProgress()) {
                    case OPEN -> task.setProgress(ProgressEnum.IN_PROGRESS);
                    case IN_PROGRESS -> task.setProgress(ProgressEnum.COMPLETED);
                }

                taskRepository.save(task);
            }
        }
    }

}
