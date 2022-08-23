package com.example.gira.service.impl;

import com.example.gira.model.entity.User;
import com.example.gira.model.service.UserServiceLoginModel;
import com.example.gira.model.service.UserServiceRegisterModel;
import com.example.gira.repository.UserRepository;
import com.example.gira.service.UserService;
import com.example.gira.util.CurrentUser;
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
    public boolean registerUser(UserServiceRegisterModel userServiceRegisterModel) {
        User user = modelMapper.map(userServiceRegisterModel, User.class);

        try {
            userRepository.save(user);

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public UserServiceLoginModel findUserByEmailAndPassword(String email, String password) {

        return userRepository.findByEmailAndPassword(email, password)
                .map(user -> modelMapper.map(user, UserServiceLoginModel.class))
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
