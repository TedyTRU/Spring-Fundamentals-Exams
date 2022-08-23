package com.example.judge.model.entiry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "problems")
public class Problem extends BaseEntity {

    private String name;
    private Integer points;

    public Problem() {
    }

    @Column(unique = true)
    public String getName() {
        return name;
    }

    public Problem setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPoints() {
        return points;
    }

    public Problem setPoints(Integer points) {
        this.points = points;
        return this;
    }
}
