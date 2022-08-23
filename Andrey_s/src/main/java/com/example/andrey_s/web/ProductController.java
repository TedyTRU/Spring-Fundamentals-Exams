package com.example.andrey_s.web;

import com.example.andrey_s.model.binding.ProductAddBindingModel;
import com.example.andrey_s.model.service.ProductServiceModel;
import com.example.andrey_s.model.view.ProductDetailViewModel;
import com.example.andrey_s.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public ProductAddBindingModel productAddBindingModel() {
        return new ProductAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {
        return "add-product";
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
        ProductServiceModel productServiceModel = productService.addProduct(modelMapper.map(productAddBindingModel, ProductServiceModel.class));

        if (productServiceModel == null) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("ProductExist", true);

            return "redirect:add";
        }

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {

        ProductDetailViewModel productDetailViewModel = productService.getProductById(id);

        model.addAttribute("productDetailViewModel", productDetailViewModel);

        return "details-product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        productService.deleteProduct(id);

        return "redirect:/";
    }

}
