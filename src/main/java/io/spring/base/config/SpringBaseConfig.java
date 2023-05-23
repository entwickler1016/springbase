package io.spring.base.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBaseConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
