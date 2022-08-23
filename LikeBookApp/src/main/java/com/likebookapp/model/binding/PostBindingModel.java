package com.likebookapp.model.binding;

import com.likebookapp.model.entity.enums.MoodNameEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostBindingModel {

    private String content;
    private MoodNameEnum mood;

    public PostBindingModel() {
    }

    @Size(min = 2, max = 150, message = "Content length must be between 2 and 150 characters!")
    public String getContent() {
        return content;
    }

    public PostBindingModel setContent(String content) {
        this.content = content;
        return this;
    }

    @NotNull(message = "Select mood!")
    public MoodNameEnum getMood() {
        return mood;
    }

    public PostBindingModel setMood(MoodNameEnum mood) {
        this.mood = mood;
        return this;
    }
}
