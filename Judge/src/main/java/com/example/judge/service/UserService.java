package com.example.judge.service;

import com.example.judge.model.service.UserServiceModel;

public interface UserService {

    boolean registerUser(UserServiceModel userRegisterServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);
}
