package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "songs")
public class Song extends BaseEntity {

    private String performer;
    private String title;
    private Integer duration;
    private LocalDate releaseDate;
    private Style style;

    public Song() {
    }

    @Column(nullable = false)
    public String getPerformer() {
        return performer;
    }

    public Song setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public Song setTitle(String title) {
        this.title = title;
        return this;
    }

    @Column(nullable = false)
    public Integer getDuration() {
        return duration;
    }

    public Song setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    @Column(nullable = true)
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Song setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @ManyToOne
    public Style getStyle() {
        return style;
    }

    public Song setStyle(Style style) {
        this.style = style;
        return this;
    }

}
