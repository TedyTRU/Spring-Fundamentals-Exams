package com.example.judge.model.binding;

import javax.validation.constraints.*;

public class ProblemBindingModel {

    private String name;
    private Integer points;

    public ProblemBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    public String getName() {
        return name;
    }

    public ProblemBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull(message = "Enter points")
    @PositiveOrZero(message = "Cannot be negative number!")
    public Integer getPoints() {
        return points;
    }

    public ProblemBindingModel setPoints(Integer points) {
        this.points = points;
        return this;
    }
}
