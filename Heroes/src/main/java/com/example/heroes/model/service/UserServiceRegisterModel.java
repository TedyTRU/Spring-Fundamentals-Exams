package com.example.heroes.model.service;

public class UserServiceRegisterModel {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String country;

    public UserServiceRegisterModel() {
    }

    public Long getId() {
        return id;
    }

    public UserServiceRegisterModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceRegisterModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceRegisterModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceRegisterModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserServiceRegisterModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserServiceRegisterModel setCountry(String country) {
        this.country = country;
        return this;
    }
}
