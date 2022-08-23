package com.example.andrey_s.service;

import com.example.andrey_s.model.service.ProductServiceModel;
import com.example.andrey_s.model.view.ProductDetailViewModel;
import com.example.andrey_s.model.view.ProductViewModel;

import java.util.List;

public interface ProductService {

    ProductServiceModel addProduct(ProductServiceModel productServiceModel);

    List<ProductViewModel> getAllProducts();

    ProductDetailViewModel getProductById(Long id);

    void deleteProduct(Long id);
}
