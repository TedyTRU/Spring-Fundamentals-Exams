package com.example.shoppinglist.service.impl;

import com.example.shoppinglist.model.entity.CategoryNameEnum;
import com.example.shoppinglist.model.entity.Product;
import com.example.shoppinglist.model.service.ProductServiceModel;
import com.example.shoppinglist.model.view.ProductViewModel;
import com.example.shoppinglist.repository.ProductRepository;
import com.example.shoppinglist.service.CategoryService;
import com.example.shoppinglist.service.ProductService;
import com.example.shoppinglist.service.UserService;
import com.example.shoppinglist.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    @Override
    public ProductServiceModel addProduct(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel, Product.class);
        product.setUser(userService.findById(currentUser.getId()));
        product.setCategory(categoryService.findCategoryByEnum(productServiceModel.getCategory()));

        return modelMapper.map(productRepository.save(product), ProductServiceModel.class);
    }

    @Override
    public void buyProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }

    @Override
    public List<ProductViewModel> findProductByCategory(CategoryNameEnum nameEnum) {

        List<Product> products = productRepository.findByCategory_Name(nameEnum);

        return products.stream().map(product -> modelMapper.map(product, ProductViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public BigDecimal getTotalPrice() {

        return productRepository
                .findAll()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
