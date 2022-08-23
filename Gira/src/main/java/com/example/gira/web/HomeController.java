package com.example.gira.web;

import com.example.gira.service.TaskService;
import com.example.gira.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
    }

    @GetMapping()
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("AllTasks", taskService.getAllTasks());

        return "home";
    }
}
