package com.example.musicdb.service;

import com.example.musicdb.model.entity.User;
import com.example.musicdb.model.service.UserLoginServiceModel;
import com.example.musicdb.model.service.UserRegisterServiceModel;

public interface UserService {

    boolean registerUser(UserRegisterServiceModel userRegisterServiceModel);

    UserLoginServiceModel findUserByUserNameAndPassword(String username, String password);

    void loginUser(Long id);

    User findUserById(Long id);

}
