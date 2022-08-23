package com.example.andrey_s.service;

import com.example.andrey_s.model.entity.Category;
import com.example.andrey_s.model.entity.enums.CategoryNameEnum;
import com.example.andrey_s.model.entity.enums.GenderEnum;

public interface CategoryService {

    void initCategories();

    Category findByCategoryEnum(CategoryNameEnum categoryNameEnum);

}
