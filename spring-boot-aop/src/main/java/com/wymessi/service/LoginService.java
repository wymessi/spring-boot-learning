package com.wymessi.service;

import com.wymessi.aop.around.aspect.AroundAuthority;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    @AroundAuthority(methodName = "getMessage")
    public String getMessage(){
        System.out.println("进入LoginSevice.getMessage()...");
        return "hello world";
    }
}
