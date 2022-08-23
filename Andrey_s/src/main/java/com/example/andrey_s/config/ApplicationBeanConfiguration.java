package com.example.andrey_s.config;

import com.example.andrey_s.model.entity.Product;
import com.example.andrey_s.model.view.ProductDetailViewModel;
import com.example.andrey_s.model.view.ProductViewModel;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        Converter<Product, String> toPicture = ctx -> ctx.getSource() == null ? null
                : String.format("/img/%s-%s.jpg",
                ctx.getSource().getGender().toString().toUpperCase(),
                ctx.getSource().getCategory().getName().toString().toUpperCase());

        modelMapper.createTypeMap(Product.class, ProductViewModel.class)
                .addMappings(mpr -> mpr.using(toPicture).map((src) -> src, ProductViewModel::setPicture));

        modelMapper.createTypeMap(Product.class, ProductDetailViewModel.class)
                .addMappings(mpr -> mpr.using(toPicture).map((src) -> src, ProductDetailViewModel::setPicture));

        return modelMapper;
    }
}
