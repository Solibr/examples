package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class LoggingExampleAspect {

    @Pointcut("@annotation(com.example.aop.myAnnotation.Logging) && execution(* *.*(..))")
    public void loggingAnnotated() {
    }

    @Before("loggingAnnotated()")
    public void beginLogging(JoinPoint joinPoint) {
        //System.out.println("Kind: " + joinPoint.getKind());
        System.out.println("Logging: attempt to do some logic");
    }

    @AfterReturning("loggingAnnotated()")
    public void successLogging() {
        System.out.println("Logging: logic execution success");
    }

    @AfterThrowing("loggingAnnotated()")
    public void failLogging() {
        System.out.println("Logging: exception during logic execution");
    }

}
