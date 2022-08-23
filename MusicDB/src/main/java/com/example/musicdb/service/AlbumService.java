package com.example.musicdb.service;

import com.example.musicdb.model.service.AlbumAddServiceModel;
import com.example.musicdb.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {

    AlbumAddServiceModel addAlbum(AlbumAddServiceModel albumAddServiceModel);

    List<AlbumViewModel> getAllAlbums();

    void deleteAlbum(Long id);

    Integer getTotalCopies();
}
