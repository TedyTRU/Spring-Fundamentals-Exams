package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.model.service.SongAddServiceModel;
import com.example.spotifyplaylistapp.model.view.AllSongViewModel;

import java.util.List;

public interface SongService {

    SongAddServiceModel addSong(SongAddServiceModel songAddServiceModel);

    List<AllSongViewModel> findSongByStyle(StyleNameEnum style);

    Song getSongById(Long id);
}
