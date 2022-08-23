package com.example.gira.model.service;

import com.example.gira.model.entity.enums.ClassificationNameEnum;

import java.time.LocalDate;

public class TaskServiceAddModel {

    private Long id;
    private String name;
    private String description;
    private LocalDate dueDate;
    private ClassificationNameEnum classification;

    public TaskServiceAddModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskServiceAddModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskServiceAddModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskServiceAddModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskServiceAddModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public TaskServiceAddModel setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
        return this;
    }
}
