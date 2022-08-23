package com.example.gira.model.service;

public class UserServiceLoginModel {

    private Long id;
    private String email;
    private String password;

    public UserServiceLoginModel() {
    }

    public Long getId() {
        return id;
    }

    public UserServiceLoginModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceLoginModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceLoginModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
