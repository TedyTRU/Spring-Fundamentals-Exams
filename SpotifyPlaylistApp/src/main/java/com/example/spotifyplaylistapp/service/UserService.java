package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.service.UserServiceModel;
import com.example.spotifyplaylistapp.model.view.AllSongViewModel;

import java.util.List;

public interface UserService {

    boolean registerUser(UserServiceModel userRegisterServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id);

    List<AllSongViewModel> getUsersPlaylist(Long id);

    void addSongToPlaylist(Long id);

    void removeAllSongs(Long id);

    Integer getTotalDuration(Long id);
}
