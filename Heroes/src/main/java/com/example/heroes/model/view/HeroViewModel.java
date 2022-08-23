package com.example.heroes.model.view;

public class HeroViewModel {

    private Long id;
    private String name;
    private String imageUrl;

    public HeroViewModel() {
    }

    public Long getId() {
        return id;
    }

    public HeroViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HeroViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public HeroViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
