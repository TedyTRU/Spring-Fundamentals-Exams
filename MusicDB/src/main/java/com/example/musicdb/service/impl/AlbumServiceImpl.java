package com.example.musicdb.service.impl;

import com.example.musicdb.model.entity.Album;
import com.example.musicdb.model.entity.Artist;
import com.example.musicdb.model.entity.User;
import com.example.musicdb.model.service.AlbumAddServiceModel;
import com.example.musicdb.model.view.AlbumViewModel;
import com.example.musicdb.repository.AlbumRepository;
import com.example.musicdb.service.AlbumService;
import com.example.musicdb.service.ArtistService;
import com.example.musicdb.service.UserService;
import com.example.musicdb.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final UserService userService;

    public AlbumServiceImpl(AlbumRepository albumRepository, CurrentUser currentUser, ModelMapper modelMapper, ArtistService artistService, UserService userService) {
        this.albumRepository = albumRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
        this.userService = userService;
    }

    @Override
    public AlbumAddServiceModel addAlbum(AlbumAddServiceModel albumAddServiceModel) {

        Artist artist = artistService.findArtistByNameEnum(albumAddServiceModel.getArtist());
        User user = userService.findUserById(currentUser.getId());

        Album album = modelMapper
                .map(albumAddServiceModel, Album.class)
                .setArtist(artist)
                .setAddedFrom(user);

        return modelMapper.map(albumRepository.save(album), AlbumAddServiceModel.class);
    }

    @Override
    public List<AlbumViewModel> getAllAlbums() {
        return albumRepository
                .findAll()
                .stream()
                .map(album -> modelMapper.map(album, AlbumViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public Integer getTotalCopies() {

        return albumRepository
                .findAll()
                .stream()
                .map(Album::getCopies)
                .reduce(Integer::sum)
                .orElse(0);

    }

}
