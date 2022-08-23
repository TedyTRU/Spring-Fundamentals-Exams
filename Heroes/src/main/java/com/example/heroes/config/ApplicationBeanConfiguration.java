package com.example.heroes.config;

import com.example.heroes.model.entity.Hero;
import com.example.heroes.model.entity.HeroClassEnum;
import com.example.heroes.model.view.HeroViewModel;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        Converter<HeroClassEnum, String> toPicture = ctx -> ctx.getSource() == null ? null
                : String.format("/img/%s.jpg", ctx.getSource().toString().toLowerCase());

        modelMapper.createTypeMap(Hero.class, HeroViewModel.class)
                .addMappings(mpr -> mpr.using(toPicture).map(Hero::getHeroClass, HeroViewModel::setImageUrl));

        return modelMapper;
    }
}
