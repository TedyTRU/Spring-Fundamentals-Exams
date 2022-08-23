package com.example.musicdb.web;

import com.example.musicdb.service.AlbumService;
import com.example.musicdb.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final AlbumService albumService;

    public HomeController(CurrentUser currentUser, AlbumService albumService) {
        this.currentUser = currentUser;
        this.albumService = albumService;
    }

    @GetMapping
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("totalCopies", albumService.getTotalCopies());
        model.addAttribute("albums", albumService.getAllAlbums());

        return "home";
    }
}
