package com.wymessi;

import com.wymessi.service.LoginService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = { "com.wymessi" })
@EnableAspectJAutoProxy
public class AopApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopApplication.class);
        LoginService loginService = (LoginService) context.getBean("loginService");
        loginService.getMessage();
    }
}
