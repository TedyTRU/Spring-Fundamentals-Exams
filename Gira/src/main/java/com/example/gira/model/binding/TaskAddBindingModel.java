package com.example.gira.model.binding;

import com.example.gira.model.entity.enums.ClassificationNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskAddBindingModel {

    private String name;
    private String description;
    private LocalDate dueDate;
    private ClassificationNameEnum classification;

    public TaskAddBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Task name length must be between 3 and 20 characters!")
    public String getName() {
        return name;
    }

    public TaskAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    //@NotBlank
    @Size(min = 5, message = "Must be at least 5 characters!")
    public String getDescription() {
        return description;
    }

    public TaskAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull
    @Future(message = "Cannot be in the past!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskAddBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @NotNull(message = "Select classification!")
    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public TaskAddBindingModel setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
        return this;
    }
}
