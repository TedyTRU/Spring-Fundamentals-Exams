package com.example.heroes.service;

import com.example.heroes.model.entity.Hero;
import com.example.heroes.model.service.HeroServiceModel;
import com.example.heroes.model.view.HeroViewModel;

import java.util.List;
import java.util.Optional;

public interface HeroService {

    boolean createHero(HeroServiceModel heroServiceModel);

    List<HeroViewModel> getAllHeroesByLevelDesc();

    Optional<HeroServiceModel> getHeroById(Long id);

    void deleteById(Long id);
}
