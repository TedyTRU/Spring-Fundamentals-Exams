package com.example.spotifyplaylistapp.model.binding;

import com.example.spotifyplaylistapp.model.entity.enums.StyleNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class SongBindingModel {

    private String performer;
    private String title;
    private Integer duration;
    private LocalDate releaseDate;
    private StyleNameEnum style;

    public SongBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Performer name length must be between 3 and 20 characters!")
    public String getPerformer() {
        return performer;
    }

    public SongBindingModel setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    @Size(min = 3, max = 20, message = "Title length must be between 3 and 20 characters!")
    public String getTitle() {
        return title;
    }

    public SongBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    @Positive
    @NotNull(message = "Please enter value!")
    public Integer getDuration() {
        return duration;
    }

    public SongBindingModel setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @PastOrPresent(message = "Cannot be in the future!")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public SongBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @NotNull(message = "Select style!")
    public StyleNameEnum getStyle() {
        return style;
    }

    public SongBindingModel setStyle(StyleNameEnum style) {
        this.style = style;
        return this;
    }
}
