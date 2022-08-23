package com.example.shoppinglist.service;

import com.example.shoppinglist.model.entity.CategoryNameEnum;
import com.example.shoppinglist.model.service.ProductServiceModel;
import com.example.shoppinglist.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductServiceModel addProduct(ProductServiceModel productServiceModel);

    void buyProduct(Long id);

    void buyAll();

    List<ProductViewModel> findProductByCategory(CategoryNameEnum nameEnum);

    BigDecimal getTotalPrice();
}
