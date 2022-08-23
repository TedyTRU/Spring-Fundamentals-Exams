package com.example.pathfinder.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    private String title;
    private String url;
    private User author;
    private Route route;

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public Picture setTitle(String title) {
        this.title = title;
        return this;
    }

    @Column(columnDefinition = "TEXT", nullable = false)
    public String getUrl() {
        return url;
    }

    public Picture setUrl(String url) {
        this.url = url;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Picture setAuthor(User author) {
        this.author = author;
        return this;
    }

    @ManyToOne
    public Route getRoute() {
        return route;
    }

    public Picture setRoute(Route route) {
        this.route = route;
        return this;
    }
}
