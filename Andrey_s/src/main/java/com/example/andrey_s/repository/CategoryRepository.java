package com.example.andrey_s.repository;

import com.example.andrey_s.model.entity.Category;
import com.example.andrey_s.model.entity.enums.CategoryNameEnum;
import com.example.andrey_s.model.entity.enums.GenderEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryNameEnum name);


}
