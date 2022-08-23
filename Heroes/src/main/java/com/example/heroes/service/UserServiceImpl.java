package com.example.heroes.service;

import com.example.heroes.model.entity.User;
import com.example.heroes.model.service.UserServiceLoginModel;
import com.example.heroes.model.service.UserServiceRegisterModel;
import com.example.heroes.repository.UserRepository;
import com.example.heroes.util.CurrentUser;
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
    public boolean registerUser(UserServiceRegisterModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);

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
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }
}
