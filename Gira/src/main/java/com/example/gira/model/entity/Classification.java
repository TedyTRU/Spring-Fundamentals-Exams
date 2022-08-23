package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.ClassificationNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity {

    private ClassificationNameEnum classificationName;
    private String description;

    public Classification() {
    }

    @Enumerated(EnumType.STRING)
    public ClassificationNameEnum getClassificationName() {
        return classificationName;
    }

    public Classification setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }
}
