package com.example.judge.model.entiry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "submissions")
public class Submission extends BaseEntity {

    private String code;
    private Integer achievedResult;
    private LocalDateTime createdOn;
    private Problem problem;
    private User user;

    public Submission() {
    }

    public String getCode() {
        return code;
    }

    public Submission setCode(String code) {
        this.code = code;
        return this;
    }

    @Column(nullable = false)
    public Integer getAchievedResult() {
        return achievedResult;
    }

    public Submission setAchievedResult(Integer achievedResult) {
        this.achievedResult = achievedResult;
        return this;
    }

    @Column(nullable = false)
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Submission setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @ManyToOne
    public Problem getProblem() {
        return problem;
    }

    public Submission setProblem(Problem problem) {
        this.problem = problem;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Submission setUser(User user) {
        this.user = user;
        return this;
    }
}
