package com.likebookapp.model.view;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.User;

public class PostViewModel {

    private Long id;
    private String content;
    private User user;
    private Integer userLikes;
    private Mood mood;

    public PostViewModel() {
    }

    public Long getId() {
        return id;
    }

    public PostViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostViewModel setContent(String content) {
        this.content = content;
        return this;
    }

    public User getUser() {
        return user;
    }

    public PostViewModel setUser(User user) {
        this.user = user;
        return this;
    }

    public Integer getUserLikes() {
        return userLikes;
    }

    public PostViewModel setUserLikes(Integer userLikes) {
        this.userLikes = userLikes;
        return this;
    }

    public Mood getMood() {
        return mood;
    }

    public PostViewModel setMood(Mood mood) {
        this.mood = mood;
        return this;
    }
}
