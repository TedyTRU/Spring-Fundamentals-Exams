package com.likebookapp.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    private String content;
    private User user;
    private Integer userLikes;
    private Mood mood;

    public Post() {
    }

    @Column(nullable = false)
    public String getContent() {
        return content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    @ManyToOne
    public Mood getMood() {
        return mood;
    }

    public Post setMood(Mood mood) {
        this.mood = mood;
        return this;
    }

    @Column(name = "user_likes")
    public Integer getUserLikes() {
        return userLikes;
    }

    public Post setUserLikes(Integer userLikes) {
        this.userLikes = userLikes;
        return this;
    }
}
