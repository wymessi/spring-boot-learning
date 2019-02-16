package com.wymessi.aop.around.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * AOP术语：
 *     1.通知（Advice）
 * 　　想要增强的功能，例如安全，事物，日志等。先定义好，然后在想用的地方使用。
 *
 *     2.连接点（JoinPoint）
 * 　　spring允许使用通知的地方，每个方法的前，后（两者都有也行），或抛出异常时都可以是连接点，spring只支持方法连接点.其他如aspectJ还可以让你在构造器或属性注入时都行
 *  *
 *     3.切入点（Pointcut）
 * 　　在连接点的基础上，来定义切入点，例如一个类里，有15个方法，那就有几十个连接点了对把，但是如果并不想在所有方法附近都使用通知（使用叫织入），那么就用切点来定义这几个方法，让切点来筛选连接点，选中那几个你想要的方法。
 *
 *     4.切面（Aspect）
 *     切面是通知和切入点的结合，该类就是一个切面
 */
@Aspect
@Component
public class AroundAspect {
    @Around("@annotation(authority)")  //这里使用了注解来定义切点
    public void loginAuthority(ProceedingJoinPoint joinPoint, AroundAuthority authority) throws Throwable {
        Random random = new Random();
        boolean b = random.nextBoolean();
        System.out.println("Around start.... ");
        System.out.println("method is " + authority.methodName());

        if (b) { // 模拟认证通过
            System.out.println("权限认证通过");
            Object result = joinPoint.proceed();
            System.out.println("执行结果" + result);
        } else {
            System.out.println("权限认证失败");
        }
        System.out.println("Around end.... ");
    }
}
