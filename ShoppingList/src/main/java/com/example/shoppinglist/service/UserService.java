package com.example.shoppinglist.service;

import com.example.shoppinglist.model.entity.User;
import com.example.shoppinglist.model.service.UserServiceModel;

public interface UserService {

    boolean registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByNameAndPassword(String username, String password);

    void loginUser(Long id);

    User findById(Long id);

}
