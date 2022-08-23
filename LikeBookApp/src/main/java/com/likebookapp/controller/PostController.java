package com.likebookapp.controller;

import com.likebookapp.model.binding.PostBindingModel;
import com.likebookapp.model.service.PostServiceModel;
import com.likebookapp.service.PostService;
import com.likebookapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final CurrentUser currentUser;
    private final PostService postService;
    private final ModelMapper modelMapper;

    public PostController(CurrentUser currentUser, PostService postService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public PostBindingModel postBindingModel() {
        return new PostBindingModel();
    }

    @GetMapping("/add")
    public String add() {

        if (currentUser.getId() == null) {
            return "redirect:/";
        }

        return "post-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid PostBindingModel postBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postBindingModel", postBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postBindingModel", bindingResult);

            return "redirect:add";
        }

        // save in DB
        PostServiceModel postAddServiceModel = modelMapper.map(postBindingModel, PostServiceModel.class);
        postService.addPost(postAddServiceModel);

        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removePost(@PathVariable Long id) {

        postService.removePost(id);

        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String likePost(@PathVariable Long id) {

        postService.likePost(id);

        return "redirect:/";
    }

}
