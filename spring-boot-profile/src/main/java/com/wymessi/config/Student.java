package com.wymessi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"student"})
public class Student{

//    @Value("${name}")
    private String name = "student name";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
