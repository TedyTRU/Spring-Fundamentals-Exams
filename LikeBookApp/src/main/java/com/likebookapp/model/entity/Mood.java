package com.likebookapp.model.entity;

import com.likebookapp.model.entity.enums.MoodNameEnum;
import javax.persistence.*;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity {

    private MoodNameEnum moodName;
    private String description;

    public Mood() {
    }

    @Enumerated(EnumType.STRING)
    public MoodNameEnum getMoodName() {
        return moodName;
    }

    public Mood setMoodName(MoodNameEnum moodName) {
        this.moodName = moodName;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Mood setDescription(String description) {
        this.description = description;
        return this;
    }
}
