package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.service.StyleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StyleServiceImpl implements StyleService {

    private final StyleRepository styleRepository;

    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void initStyles() {

        if (styleRepository.count() != 0) {
            return;
        }

        List<Style> styles = Arrays.stream(StyleNameEnum.values())
                .map(styleNameEnum -> {
                    Style style = new Style()
                            .setStyleName(styleNameEnum)
                            .setDescription(String.format("info for style %s ...", styleNameEnum));

                    return style;
                }).toList();

        styleRepository.saveAll(styles);
    }

    @Override
    public Style findStyleByNameEnum(StyleNameEnum style) {

        return styleRepository.findByStyleName(style).orElse(null);
    }
}
