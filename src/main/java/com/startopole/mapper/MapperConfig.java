package com.startopole.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public Mapper mapper() {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper::map;
    }
}
