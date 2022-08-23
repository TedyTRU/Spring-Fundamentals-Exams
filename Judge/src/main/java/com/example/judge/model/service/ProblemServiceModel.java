package com.example.judge.model.service;

public class ProblemServiceModel {

    private Long id;
    private String name;
    private Integer points;

    public ProblemServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ProblemServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProblemServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPoints() {
        return points;
    }

    public ProblemServiceModel setPoints(Integer points) {
        this.points = points;
        return this;
    }
}
