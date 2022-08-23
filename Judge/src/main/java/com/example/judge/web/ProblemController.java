package com.example.judge.web;

import com.example.judge.model.binding.ProblemBindingModel;
import com.example.judge.model.service.ProblemServiceModel;
import com.example.judge.model.service.UserServiceModel;
import com.example.judge.service.ProblemService;
import com.example.judge.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/problems")
public class ProblemController {

    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final ProblemService problemService;

    public ProblemController(CurrentUser currentUser, ModelMapper modelMapper, ProblemService problemService) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.problemService = problemService;
    }

    @ModelAttribute
    public ProblemBindingModel problemBindingModel() {
        return new ProblemBindingModel();
    }

    @GetMapping("/create")
    public String create() {

        if (currentUser.getId() == null) {
            return "redirect:/";
        }

        return "create-problem";
    }

    @PostMapping("/create")
    public String createConfirm(@Valid ProblemBindingModel problemBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("problemBindingModel", problemBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.problemBindingModel", bindingResult);

            return "redirect:create";
        }

        // save in DB
        ProblemServiceModel problemServiceModel = modelMapper.map(problemBindingModel, ProblemServiceModel.class);
        boolean success = problemService.createProblem(problemServiceModel);

        if (!success) {
            redirectAttributes.addFlashAttribute("problemBindingModel", problemBindingModel);
            redirectAttributes.addFlashAttribute("ProblemExist", true);

            return "redirect:create";
        }

        return "redirect:/";
    }

    @GetMapping("/submit")
    public String submit() {

        if (currentUser.getId() == null) {
            return "redirect:/";
        }

        return "create-submission";
    }


}
