package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.ProgressEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {

    private String name;
    private String description;
    private ProgressEnum progress;
    private LocalDate date;
    private Classification classification;
    private User user;

    public Task() {
    }

    @Column(unique = true)
    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public ProgressEnum getProgress() {
        return progress;
    }

    public Task setProgress(ProgressEnum progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Task setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @ManyToOne
    public Classification getClassification() {
        return classification;
    }

    public Task setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Task setUser(User user) {
        this.user = user;
        return this;
    }
}
