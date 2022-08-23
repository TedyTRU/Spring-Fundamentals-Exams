package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.service.UserServiceModel;
import com.example.spotifyplaylistapp.model.view.AllSongViewModel;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final SongService songService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, SongService songService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.songService = songService;
    }

    @Override
    public boolean registerUser(UserServiceModel userRegisterServiceModel) {

        User user = modelMapper.map(userRegisterServiceModel, User.class);
        user.setPlaylist(new ArrayList<>());

        try {
            userRepository.save(user);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {

        return userRepository
                .findUserByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id) {
        currentUser.setId(id);
    }

    @Override
    public List<AllSongViewModel> getUsersPlaylist(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return new ArrayList<>();
        }

        return user.getPlaylist().stream().map(song -> modelMapper.map(song, AllSongViewModel.class)).toList();

    }

    @Override
    public void addSongToPlaylist(Long id) {
        User user = userRepository.findById(currentUser.getId()).orElse(null);
        if (user == null) {
            return;
        }

        Song song = songService.getSongById(id);
        if (song == null) {
            return;
        }

        List<Song> songs = user.getPlaylist();
        songs.add(song);
        user.setPlaylist(songs);

        userRepository.save(user);
    }

    @Override
    public void removeAllSongs(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return;
        }

        user.setPlaylist(new ArrayList<>());
//        user.getPlaylist().clear();
        userRepository.save(user);
    }

    @Override
    public Integer getTotalDuration(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return 0;
        }

        return user.getPlaylist().stream().map(Song::getDuration).reduce(Integer::sum).orElse(0);
    }

}
