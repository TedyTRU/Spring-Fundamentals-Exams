package com.example.shoppinglist.service.impl;

import com.example.shoppinglist.model.entity.Category;
import com.example.shoppinglist.model.entity.CategoryNameEnum;
import com.example.shoppinglist.repository.CategoryRepository;
import com.example.shoppinglist.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void initCategory() {

        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryEnum -> {
                    Category category = new Category();
                    category.setName(categoryEnum);

                    categoryRepository.save(category);
                });

    }

    @Override
    public Category findCategoryByEnum(CategoryNameEnum category) {

        return categoryRepository.findByName(category).orElse(null);
    }
}
