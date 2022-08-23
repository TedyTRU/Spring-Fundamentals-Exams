package com.example.heroes.web;

import com.example.heroes.model.binding.HeroCreateBindingModel;
import com.example.heroes.model.service.HeroServiceModel;
import com.example.heroes.service.HeroService;
import com.example.heroes.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/heroes")
public class HeroController {

    private final HeroService heroService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public HeroController(HeroService heroService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public HeroCreateBindingModel heroCreateBindingModel() {
        return new HeroCreateBindingModel();
    }

    @GetMapping("/create")
    public String create() {

        if (currentUser.getId() == null) {
            return "redirect:/users/login";
        }

        return "create-hero";
    }

    @PostMapping("/create")
    public String createConfirm(@Valid HeroCreateBindingModel heroCreateBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("heroCreateBindingModel", heroCreateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.heroCreateBindingModel", bindingResult);

            return "redirect:create";
        }

        // save in DB
        HeroServiceModel heroServiceModel = modelMapper.map(heroCreateBindingModel, HeroServiceModel.class);
        boolean successCreateHero = heroService.createHero(heroServiceModel);

        if (!successCreateHero) {
            redirectAttributes.addFlashAttribute("heroCreateBindingModel", heroCreateBindingModel);
            redirectAttributes.addFlashAttribute("HeroNameIsOccupied", true);

            return "redirect:create";
        }

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {

        Optional<HeroServiceModel> heroById = heroService.getHeroById(id);

        model.addAttribute("hero", heroById.get());

        return "details-hero";
    }

    @GetMapping("/delete/{id}")
    public String deleteGet(@PathVariable Long id, Model model) {

        Optional<HeroServiceModel> heroById = heroService.getHeroById(id);

        model.addAttribute("hero", heroById.get());

        return "delete-hero";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        heroService.deleteById(id);

        return "redirect:/";
    }
}
