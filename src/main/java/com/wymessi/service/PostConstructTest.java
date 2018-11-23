package com.wymessi.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PostConstructTest {

    @PostConstruct
    public void init(){
        System.out.println("=========================================================");
    }
}
