package com.likebookapp.controller;

import com.likebookapp.service.PostService;
import com.likebookapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final PostService postService;

    public HomeController(CurrentUser currentUser, PostService postService) {
        this.currentUser = currentUser;
        this.postService = postService;
    }

    @GetMapping()
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("User", currentUser.getUsername());
        model.addAttribute("MyPosts", postService.getUsersPosts(currentUser.getId()));

        model.addAttribute("allOthersPosts", postService.getAllOthersPosts(currentUser.getId()));
        model.addAttribute("countOfPosts", postService.getCountOfPosts(currentUser.getId()));

        return "home";
    }

}
