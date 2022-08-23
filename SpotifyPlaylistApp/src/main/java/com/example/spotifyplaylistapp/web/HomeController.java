package com.example.spotifyplaylistapp.web;

import com.example.spotifyplaylistapp.model.entity.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final SongService songService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, SongService songService, UserService userService) {
        this.currentUser = currentUser;
        this.songService = songService;
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("pop", songService.findSongByStyle(StyleNameEnum.POP));
        model.addAttribute("jazz", songService.findSongByStyle(StyleNameEnum.JAZZ));
        model.addAttribute("rock", songService.findSongByStyle(StyleNameEnum.ROCK));

        model.addAttribute("myPlaylist", userService.getUsersPlaylist(currentUser.getId()));
        model.addAttribute("totalDuration", userService.getTotalDuration(currentUser.getId()));

        return "home";
    }
}
