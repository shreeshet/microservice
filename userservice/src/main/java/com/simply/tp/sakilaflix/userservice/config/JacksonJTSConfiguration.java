package com.simply.tp.sakilaflix.userservice.config;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shreeharshashet on 2/13/18.
 */
@Configuration
public class JacksonJTSConfiguration {
    @Bean
    public JtsModule jtsModule() {
        return new JtsModule();
    }
}
