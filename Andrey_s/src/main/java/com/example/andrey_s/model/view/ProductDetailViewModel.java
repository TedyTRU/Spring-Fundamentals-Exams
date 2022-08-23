package com.example.andrey_s.model.view;

import java.math.BigDecimal;

public class ProductDetailViewModel {

    private Long id;
    private String name;
    private String picture;
    private String description;
    private BigDecimal price;

    public ProductDetailViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductDetailViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDetailViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public ProductDetailViewModel setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDetailViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductDetailViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
