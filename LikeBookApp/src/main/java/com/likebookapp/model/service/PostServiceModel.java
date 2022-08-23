package com.likebookapp.model.service;

import com.likebookapp.model.entity.enums.MoodNameEnum;

public class PostServiceModel {

    private Long id;
    private String content;
    private MoodNameEnum mood;

    public PostServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public PostServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostServiceModel setContent(String content) {
        this.content = content;
        return this;
    }

    public MoodNameEnum getMood() {
        return mood;
    }

    public PostServiceModel setMood(MoodNameEnum mood) {
        this.mood = mood;
        return this;
    }
}
