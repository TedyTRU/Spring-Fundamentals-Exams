package com.likebookapp.service;

import com.likebookapp.model.entity.User;
import com.likebookapp.model.service.UserServiceModel;

public interface UserService {

    boolean registerUser(UserServiceModel userRegisterServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findUserById(Long id);

}
