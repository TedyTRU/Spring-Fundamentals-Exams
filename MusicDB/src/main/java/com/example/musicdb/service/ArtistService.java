package com.example.musicdb.service;

import com.example.musicdb.model.entity.Artist;
import com.example.musicdb.model.entity.enums.ArtistNameEnum;

public interface ArtistService {

    void initArtist();

    Artist findArtistByNameEnum(ArtistNameEnum artist);

}
