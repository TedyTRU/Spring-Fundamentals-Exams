package com.example.heroes.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String country;

    public UserRegisterBindingModel() {
    }

    //    @NotBlank(message = "Username is required!")
    @Size(min = 3, max = 20, message = "Username must be at least 3 characters long!")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank(message = "Email is required!")
    // @Email(regexp = "^(\\w+@\\w+)(.\\w+){2,}$", message = "Enter valid email address!")
    @Email
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Password is required!")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank(message = "Confirm Password is required!")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @NotBlank(message = "Country is required!")
    public String getCountry() {
        return country;
    }

    public UserRegisterBindingModel setCountry(String country) {
        this.country = country;
        return this;
    }
}
