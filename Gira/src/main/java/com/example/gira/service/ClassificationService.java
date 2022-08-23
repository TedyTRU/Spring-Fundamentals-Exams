package com.example.gira.service;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.enums.ClassificationNameEnum;

public interface ClassificationService {

    void initClassification();

    Classification findByEnum(ClassificationNameEnum classificationEnum);
}
