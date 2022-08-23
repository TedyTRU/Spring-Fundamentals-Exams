package com.example.andrey_s.service.impl;

import com.example.andrey_s.model.entity.Product;
import com.example.andrey_s.model.entity.enums.CategoryNameEnum;
import com.example.andrey_s.model.service.ProductServiceModel;
import com.example.andrey_s.model.view.ProductDetailViewModel;
import com.example.andrey_s.model.view.ProductViewModel;
import com.example.andrey_s.repository.ProductRepository;
import com.example.andrey_s.service.CategoryService;
import com.example.andrey_s.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public ProductServiceModel addProduct(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel, Product.class);

        CategoryNameEnum categoryEnum = CategoryNameEnum.valueOf(productServiceModel.getCategory());

        product.setCategory(categoryService.findByCategoryEnum(categoryEnum));
        product.setGender(productServiceModel.getSex());

        try {
            productRepository.save(product);
        } catch (Exception e) {
            return null;
        }

        return modelMapper.map(product, ProductServiceModel.class);
    }

    @Override
    public List<ProductViewModel> getAllProducts() {

        return productRepository
                .findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDetailViewModel getProductById(Long id) {

        return productRepository
                .findById(id)
                .map(product -> modelMapper.map(product, ProductDetailViewModel.class))
                .orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }

}
