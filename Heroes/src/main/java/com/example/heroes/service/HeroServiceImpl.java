package com.example.heroes.service;

import com.example.heroes.model.entity.Hero;
import com.example.heroes.model.service.HeroServiceModel;
import com.example.heroes.model.view.HeroViewModel;
import com.example.heroes.repository.HeroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final ModelMapper modelMapper;

    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean createHero(HeroServiceModel heroServiceModel) {
        Hero hero = modelMapper.map(heroServiceModel, Hero.class);

        try {
            heroRepository.save(hero);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<HeroViewModel> getAllHeroesByLevelDesc() {

        List<Hero> heroes = heroRepository.findAllOrderByLevelDesc();

        return heroes.stream().map(hero -> modelMapper.map(hero, HeroViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<HeroServiceModel> getHeroById(Long id) {

        return heroRepository.findById(id).map(hero -> modelMapper.map(hero, HeroServiceModel.class));
    }

    @Override
    public void deleteById(Long id) {

        heroRepository.deleteById(id);
    }

}
