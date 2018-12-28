package com.wymessi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev"})
public class JavaConfig {


    @ConfigurationProperties(prefix = "stu")
    @Bean
    public Student student(){
        return new Student();
    }
}
