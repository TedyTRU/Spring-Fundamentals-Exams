package com.example.heroes.model.service;

import com.example.heroes.model.entity.HeroClassEnum;

public class HeroServiceModel {

    private Long id;
    private String name;
    private HeroClassEnum heroClass;
    private Integer level;

    public HeroServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public HeroServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HeroServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public HeroClassEnum getHeroClass() {
        return heroClass;
    }

    public HeroServiceModel setHeroClass(HeroClassEnum heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public HeroServiceModel setLevel(Integer level) {
        this.level = level;
        return this;
    }
}
