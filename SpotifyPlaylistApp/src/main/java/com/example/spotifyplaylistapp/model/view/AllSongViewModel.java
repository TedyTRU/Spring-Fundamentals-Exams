package com.example.spotifyplaylistapp.model.view;

import com.example.spotifyplaylistapp.model.entity.Style;

public class AllSongViewModel {

    private Long id;
    private String performer;
    private String title;
    private Integer duration;
    private Style style;

    public AllSongViewModel() {
    }

    public Long getId() {
        return id;
    }

    public AllSongViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public AllSongViewModel setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AllSongViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public AllSongViewModel setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public Style getStyle() {
        return style;
    }

    public AllSongViewModel setStyle(Style style) {
        this.style = style;
        return this;
    }
}
