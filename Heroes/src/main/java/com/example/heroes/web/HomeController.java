package com.example.heroes.web;

import com.example.heroes.service.HeroService;
import com.example.heroes.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final HeroService heroService;
    private final CurrentUser currentUser;

    public HomeController(HeroService heroService, CurrentUser currentUser) {
        this.heroService = heroService;
        this.currentUser = currentUser;
    }

    @GetMapping()
    private String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("heroes", heroService.getAllHeroesByLevelDesc());

        return "home";
    }
}
