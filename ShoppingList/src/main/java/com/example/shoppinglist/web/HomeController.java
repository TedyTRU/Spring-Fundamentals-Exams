package com.example.shoppinglist.web;

import com.example.shoppinglist.model.entity.CategoryNameEnum;
import com.example.shoppinglist.service.ProductService;
import com.example.shoppinglist.user.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }

    @GetMapping()
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("foods", productService.findProductByCategory(CategoryNameEnum.Food));
        model.addAttribute("drinks", productService.findProductByCategory(CategoryNameEnum.Drink));
        model.addAttribute("household", productService.findProductByCategory(CategoryNameEnum.Household));
        model.addAttribute("other", productService.findProductByCategory(CategoryNameEnum.Other));

        model.addAttribute("totalPriceOfProducts", productService.getTotalPrice());

        return "home";
    }
}
