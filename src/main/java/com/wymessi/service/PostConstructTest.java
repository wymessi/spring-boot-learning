package com.wymessi.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PostConstructTest {

    /**
     * 服务一启动就会执行init方法
     */
    @PostConstruct
    public void init(){
        System.out.println("=========================================================");
    }
}
