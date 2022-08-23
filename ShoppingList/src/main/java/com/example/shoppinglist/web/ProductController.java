package com.example.shoppinglist.web;

import com.example.shoppinglist.model.binding.ProductAddBindingModel;
import com.example.shoppinglist.model.service.ProductServiceModel;
import com.example.shoppinglist.service.ProductService;
import com.example.shoppinglist.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public ProductController(ProductService productService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute()
    public ProductAddBindingModel productAddBindingModel() {
        return new ProductAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {

        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);

            return "redirect:add";
        }

        // add to DB
        ProductServiceModel productServiceModel = modelMapper.map(productAddBindingModel, ProductServiceModel.class);
        productService.addProduct(productServiceModel);

        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id) {

        if (currentUser.getId() == null) {
            return "redirect:/users/login";
        }

        productService.buyProduct(id);
        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyAll() {

        if (currentUser.getId() == null) {
            return "redirect:/users/login";
        }

        productService.buyAll();
        return "redirect:/";
    }
}
