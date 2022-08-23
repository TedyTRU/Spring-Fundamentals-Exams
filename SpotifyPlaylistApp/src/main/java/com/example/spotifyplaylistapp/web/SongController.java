package com.example.spotifyplaylistapp.web;

import com.example.spotifyplaylistapp.model.binding.SongBindingModel;
import com.example.spotifyplaylistapp.model.service.SongAddServiceModel;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final CurrentUser currentUser;
    private final SongService songService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public SongController(CurrentUser currentUser, SongService songService, UserService userService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.songService = songService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public SongBindingModel songBindingModel() {
        return new SongBindingModel();
    }

    @GetMapping("/add")
    public String add() {

        if (currentUser.getId() == null) {
            return "redirect:/";
        }

        return "song-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid SongBindingModel songBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("songBindingModel", songBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.songBindingModel", bindingResult);

            return "redirect:add";
        }

        // save in DB
        SongAddServiceModel songAddServiceModel = modelMapper.map(songBindingModel, SongAddServiceModel.class);
        songService.addSong(songAddServiceModel);

        return "redirect:/";
    }

    @GetMapping("/add/{id}")
    public String addSong(@PathVariable Long id) {

        userService.addSongToPlaylist(id);

        return "redirect:/";
    }

    @GetMapping("/remove")
    public String removeAll() {

        userService.removeAllSongs(currentUser.getId());

        return "redirect:/";
    }
}
