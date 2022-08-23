package com.example.heroes.model.binding;

import com.example.heroes.model.entity.HeroClassEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class HeroCreateBindingModel {

    private String name;
    private HeroClassEnum heroClass;
    private Integer level;

    public HeroCreateBindingModel() {
    }

    @NotBlank(message = "Username is required!")
    public String getName() {
        return name;
    }

    public HeroCreateBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull(message = "Hero class must not be null!")
    public HeroClassEnum getHeroClass() {
        return heroClass;
    }

    public HeroCreateBindingModel setHeroClass(HeroClassEnum heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    @NotNull(message = "Level is required!")
    @Positive(message = "Level must be positive number!")
    public Integer getLevel() {
        return level;
    }

    public HeroCreateBindingModel setLevel(Integer level) {
        this.level = level;
        return this;
    }
}
