package com.likebookapp.service;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.enums.MoodNameEnum;

public interface MoodService {

    void initMoods();

    Mood findMoodByNameEnum(MoodNameEnum mood);
}
