package com.example.gira.service.impl;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.enums.ClassificationNameEnum;
import com.example.gira.repository.ClassificationRepository;
import com.example.gira.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initClassification() {

        if (classificationRepository.count() != 0) {
            return;
        }

        List<Classification> categories = Arrays.stream(ClassificationNameEnum.values())
                .map(classificationNameEnum -> new Classification()
                        .setClassificationName(classificationNameEnum)
                        .setDescription(descriptionInfo(classificationNameEnum)))
                .toList();

        classificationRepository.saveAll(categories);

    }

    private String descriptionInfo(ClassificationNameEnum classificationNameEnum) {
        return switch (classificationNameEnum) {
            case BUG -> "info BUG ...";
            case SUPPORT -> "info SUPPORT ...";
            case FEATURE -> "info FEATURE ...";
            case OTHER -> "info OTHER ...";
        };
    }

    @Override
    public Classification findByEnum(ClassificationNameEnum classificationEnum) {
        return classificationRepository
                .findByClassificationName(classificationEnum)
                .orElse(null);
    }
}
