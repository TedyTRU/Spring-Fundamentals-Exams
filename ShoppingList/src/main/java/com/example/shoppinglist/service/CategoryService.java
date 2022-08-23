package com.example.shoppinglist.service;

import com.example.shoppinglist.model.entity.Category;
import com.example.shoppinglist.model.entity.CategoryNameEnum;

public interface CategoryService {

    void initCategory();

    Category findCategoryByEnum(CategoryNameEnum category);
}
