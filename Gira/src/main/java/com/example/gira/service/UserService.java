package com.example.gira.service;

import com.example.gira.model.entity.User;
import com.example.gira.model.service.UserServiceLoginModel;
import com.example.gira.model.service.UserServiceRegisterModel;

public interface UserService {

    boolean registerUser(UserServiceRegisterModel userServiceRegisterModel);

    UserServiceLoginModel findUserByEmailAndPassword(String email, String password);

    void loginUser(Long id);

    User findUserById(Long id);
}
