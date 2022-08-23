package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.entity.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.model.service.SongAddServiceModel;
import com.example.spotifyplaylistapp.model.view.AllSongViewModel;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.StyleService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {

    private final ModelMapper modelMapper;
    private final SongRepository songRepository;
    private final StyleService styleService;

    public SongServiceImpl(ModelMapper modelMapper, SongRepository songRepository, StyleService styleService) {
        this.modelMapper = modelMapper;
        this.songRepository = songRepository;
        this.styleService = styleService;
    }

    @Override
    public SongAddServiceModel addSong(SongAddServiceModel songAddServiceModel) {

        Style style = styleService.findStyleByNameEnum(songAddServiceModel.getStyle());

        Song song = modelMapper.map(songAddServiceModel, Song.class)
                .setStyle(style);

        return modelMapper.map(songRepository.save(song), SongAddServiceModel.class);
    }

    @Override
    public List<AllSongViewModel> findSongByStyle(StyleNameEnum styleEnum) {

        return songRepository.findByStyle_StyleName(styleEnum)
                .stream()
                .map(song -> modelMapper.map(song, AllSongViewModel.class))
                .toList();
    }

    @Override
    public Song getSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

}
