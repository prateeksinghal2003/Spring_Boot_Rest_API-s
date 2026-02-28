package com.example.learning_rest_api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//it tells making bean of different classes
//can also adjust some settings while making bean, can adjust the bean
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}


//modelMapper is just a bean name; ModelMapper is a third-party library class,
//and the @Bean method registers its object in the Spring container for dependency injection.


/*Spring startup:
Calls method
Creates ModelMapper object
Stores in IoC container
Injects wherever needed */