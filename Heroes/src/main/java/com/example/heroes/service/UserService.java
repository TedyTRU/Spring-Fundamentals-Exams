package com.example.heroes.service;

import com.example.heroes.model.service.UserServiceLoginModel;
import com.example.heroes.model.service.UserServiceRegisterModel;

public interface UserService {

    boolean registerUser(UserServiceRegisterModel userServiceModel);

    UserServiceLoginModel findUserByNameAndPassword(String username, String password);

    void loginUser(Long id, String username);

}
