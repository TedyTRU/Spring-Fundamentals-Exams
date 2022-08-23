package com.example.pathfinder.service;
;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.sevice.UserServiceModel;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginCurrentUser(Long id, String username);

    void logout();

    UserServiceModel findById(Long id);

    boolean isNameExists(String username);

    User findCurrentLoginUserEntity();
}
