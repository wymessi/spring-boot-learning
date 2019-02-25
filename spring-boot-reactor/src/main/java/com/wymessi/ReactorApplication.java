package com.wymessi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wymessi")
public class ReactorApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ReactorApplication.class, args);
    }
}
