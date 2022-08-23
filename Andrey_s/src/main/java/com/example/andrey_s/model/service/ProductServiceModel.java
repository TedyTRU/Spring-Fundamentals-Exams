package com.example.andrey_s.model.service;

import com.example.andrey_s.model.entity.enums.GenderEnum;

import java.math.BigDecimal;

public class ProductServiceModel {

    private Long id;
    private String name;
    private String description;
    private String category;
    private GenderEnum sex;
    private BigDecimal price;

    public ProductServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductServiceModel setCategory(String category) {
        this.category = category;
        return this;
    }

    public GenderEnum getSex() {
        return sex;
    }

    public ProductServiceModel setSex(GenderEnum sex) {
        this.sex = sex;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
