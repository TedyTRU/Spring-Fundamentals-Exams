package com.example.judge.model.binding;

import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters!")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
