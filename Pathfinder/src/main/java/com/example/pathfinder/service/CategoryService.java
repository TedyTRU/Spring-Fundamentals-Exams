package com.example.pathfinder.service;

import com.example.pathfinder.model.entity.Category;
import com.example.pathfinder.model.entity.enums.CategoryNameEnum;

import java.util.Optional;

public interface CategoryService {

    Category findCategoryByName(CategoryNameEnum categoryNameEnum);
}
