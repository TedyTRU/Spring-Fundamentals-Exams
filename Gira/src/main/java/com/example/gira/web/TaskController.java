package com.example.gira.web;

import com.example.gira.model.binding.TaskAddBindingModel;
import com.example.gira.model.service.TaskServiceAddModel;
import com.example.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public TaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public TaskAddBindingModel taskAddBindingModel() {
        return new TaskAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {

        return "add-task";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid TaskAddBindingModel taskAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);

            return "redirect:add";
        }

        // save in DB
        TaskServiceAddModel taskServiceAddModel = modelMapper.map(taskAddBindingModel, TaskServiceAddModel.class);
        taskService.addTask(taskServiceAddModel);

        return "redirect:/";
    }

    @GetMapping("/progress/{id}")
    public String progress(@PathVariable Long id) {
        taskService.changeProgress(id);

        return "redirect:/";
    }
}
