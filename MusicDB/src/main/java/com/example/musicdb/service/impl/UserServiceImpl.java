package com.example.musicdb.service.impl;

import com.example.musicdb.model.entity.User;
import com.example.musicdb.model.service.UserLoginServiceModel;
import com.example.musicdb.model.service.UserRegisterServiceModel;
import com.example.musicdb.repository.UserRepository;
import com.example.musicdb.service.UserService;
import com.example.musicdb.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public boolean registerUser(UserRegisterServiceModel userRegisterServiceModel) {
        User user = modelMapper.map(userRegisterServiceModel, User.class);

        try {
            userRepository.save(user);

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public UserLoginServiceModel findUserByUserNameAndPassword(String username, String password) {

        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserLoginServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id) {
        currentUser.setId(id);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
