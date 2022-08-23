package com.example.andrey_s.model.binding;

import com.example.andrey_s.model.entity.enums.GenderEnum;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ProductAddBindingModel {

    private String name;
    private String description;
    private String category;
    private GenderEnum sex;
    private BigDecimal price;

    public ProductAddBindingModel() {
    }

    @Size(min = 2)
    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 3)
    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotEmpty(message = "Select category!")
    public String getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(String category) {
        this.category = category;
        return this;
    }

    @NotNull(message = "Select gender!")
    public GenderEnum getSex() {
        return sex;
    }

    public ProductAddBindingModel setSex(GenderEnum sex) {
        this.sex = sex;
        return this;
    }

    @Positive
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
