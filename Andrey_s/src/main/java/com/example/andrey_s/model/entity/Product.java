package com.example.andrey_s.model.entity;

import com.example.andrey_s.model.entity.enums.GenderEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private GenderEnum gender;

    public Product() {
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @ManyToOne(fetch = FetchType.EAGER)
    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public GenderEnum getGender() {
        return gender;
    }

    public Product setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }
}
