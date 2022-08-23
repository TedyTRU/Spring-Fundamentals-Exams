package com.example.heroes.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {

    private String name;
    private HeroClassEnum heroClass;
    private Integer level;

    public Hero() {
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public Hero setName(String name) {
        this.name = name;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "class", nullable = false)
    public HeroClassEnum getHeroClass() {
        return heroClass;
    }

    public Hero setHeroClass(HeroClassEnum herClass) {
        this.heroClass = herClass;
        return this;
    }

    @Column(nullable = false)
    public Integer getLevel() {
        return level;
    }

    public Hero setLevel(Integer level) {
        this.level = level;
        return this;
    }
}
