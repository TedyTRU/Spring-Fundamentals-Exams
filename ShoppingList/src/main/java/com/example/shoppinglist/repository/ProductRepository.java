package com.example.shoppinglist.repository;

import com.example.shoppinglist.model.entity.CategoryNameEnum;
import com.example.shoppinglist.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory_Name(CategoryNameEnum category_name);
}
