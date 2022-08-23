package com.example.andrey_s.service;

import com.example.andrey_s.model.service.UserServiceLoginModel;
import com.example.andrey_s.model.service.UserServiceRegisterModel;

public interface UserService {

    boolean registerUser(UserServiceRegisterModel userServiceRegisterModel);

    UserServiceLoginModel findUserByNameAndPassword(String username, String password);

    void loginUser(Long id);

}
