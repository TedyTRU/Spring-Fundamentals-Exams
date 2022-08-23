package com.example.musicdb.web;

import com.example.musicdb.model.binding.AlbumAddBindingModel;
import com.example.musicdb.model.service.AlbumAddServiceModel;
import com.example.musicdb.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("albums/")
public class AlbumController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public AlbumAddBindingModel albumAddBindingModel() {
        return new AlbumAddBindingModel();
    }

    @GetMapping("/add")
    public String addAlbum() {

        return "add-album";
    }

    @PostMapping("/add")
    public String confirmAddAlbum(@Valid AlbumAddBindingModel albumAddBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);

            return "redirect:add";
        }

        // add to DB
        AlbumAddServiceModel albumAddServiceModel = modelMapper.map(albumAddBindingModel, AlbumAddServiceModel.class);
        albumService.addAlbum(albumAddServiceModel);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        albumService.deleteAlbum(id);

        return "redirect:/";
    }
}
