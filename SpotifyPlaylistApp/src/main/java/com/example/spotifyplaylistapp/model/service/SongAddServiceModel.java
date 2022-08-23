package com.example.spotifyplaylistapp.model.service;

import com.example.spotifyplaylistapp.model.entity.enums.StyleNameEnum;

import java.time.LocalDate;

public class SongAddServiceModel {

    private Long id;
    private String performer;
    private String title;
    private Integer duration;
    private LocalDate releaseDate;
    private StyleNameEnum style;

    public SongAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public SongAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SongAddServiceModel setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongAddServiceModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongAddServiceModel setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public SongAddServiceModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public StyleNameEnum getStyle() {
        return style;
    }

    public SongAddServiceModel setStyle(StyleNameEnum style) {
        this.style = style;
        return this;
    }
}
