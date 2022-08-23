package com.example.andrey_s.service.impl;

import com.example.andrey_s.model.entity.Category;
import com.example.andrey_s.model.entity.enums.CategoryNameEnum;
import com.example.andrey_s.model.entity.enums.GenderEnum;
import com.example.andrey_s.repository.CategoryRepository;
import com.example.andrey_s.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);

                    categoryRepository.save(category);
                });

    }

    @Override
    public Category findByCategoryEnum(CategoryNameEnum category) {
        return categoryRepository.findByName(category).orElse(null);
    }

}
