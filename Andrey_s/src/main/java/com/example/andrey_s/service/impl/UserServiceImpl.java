package com.example.andrey_s.service.impl;

import com.example.andrey_s.model.entity.User;
import com.example.andrey_s.model.service.UserServiceLoginModel;
import com.example.andrey_s.model.service.UserServiceRegisterModel;
import com.example.andrey_s.repository.UserRepository;
import com.example.andrey_s.service.UserService;
import com.example.andrey_s.util.CurrentUser;
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
    public UserServiceLoginModel findUserByNameAndPassword(String username, String password) {

        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceLoginModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id) {
        currentUser.setId(id);
    }
}
