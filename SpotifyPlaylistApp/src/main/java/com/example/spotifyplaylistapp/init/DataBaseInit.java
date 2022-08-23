package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.service.StyleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {

    private final StyleService service;

    public DataBaseInit(StyleService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        service.initStyles();
    }
}
