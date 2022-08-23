package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.enums.StyleNameEnum;

public interface StyleService {

    void initStyles();

    Style findStyleByNameEnum(StyleNameEnum style);
}
