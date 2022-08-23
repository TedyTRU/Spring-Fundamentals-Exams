package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.entity.enums.StyleNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "styles")
public class Style extends BaseEntity {

    private StyleNameEnum styleName;
    private String description;

    public Style() {
    }

    @Enumerated(EnumType.STRING)
    public StyleNameEnum getStyleName() {
        return styleName;
    }

    public Style setStyleName(StyleNameEnum styleName) {
        this.styleName = styleName;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Style setDescription(String description) {
        this.description = description;
        return this;
    }
}
