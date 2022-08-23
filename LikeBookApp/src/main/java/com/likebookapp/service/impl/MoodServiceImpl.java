package com.likebookapp.service.impl;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.enums.MoodNameEnum;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.service.MoodService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoodServiceImpl implements MoodService {

    private final MoodRepository moodRepository;

    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void initMoods() {

        if (moodRepository.count() != 0) {
            return;
        }

        List<Mood> moods = Arrays.stream(MoodNameEnum.values())
                .map(moodNameEnum -> new Mood()
                        .setMoodName(moodNameEnum)
                        .setDescription(String.format("info for mood %s ...", moodNameEnum))).collect(Collectors.toList());

        moodRepository.saveAll(moods);
    }

    @Override
    public Mood findMoodByNameEnum(MoodNameEnum mood) {

        return moodRepository.findByMoodName(mood).orElse(null);
    }

}
