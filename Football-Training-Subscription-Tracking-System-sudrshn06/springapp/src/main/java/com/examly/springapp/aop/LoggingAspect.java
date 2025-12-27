package com.examly.springapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.examly.springapp.service.*.*(..))")
    public void beforeServiceMethod(JoinPoint joinPoint) {
        System.out.println(
            "Before executing: " +
            joinPoint.getSignature().getDeclaringTypeName() +
            "." +
            joinPoint.getSignature().getName()
        );
    }

    @After("execution(* com.examly.springapp.service.*.*(..))")
    public void afterServiceMethod(JoinPoint joinPoint) {
        System.out.println(
            "After executing: " +
            joinPoint.getSignature().getDeclaringTypeName() +
            "." +
            joinPoint.getSignature().getName()
        );
    }
}