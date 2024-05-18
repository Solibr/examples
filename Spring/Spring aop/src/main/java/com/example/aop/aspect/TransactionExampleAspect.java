package com.example.aop.aspect;

import com.example.aop.myAnnotation.Transaction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class TransactionExampleAspect {

    @Pointcut("@annotation(com.example.aop.myAnnotation.Transaction) && execution(* *.*(..))")
    public void transactionAnnotated() {
    }

    @Before("transactionAnnotated()")
    public void beginTransaction() {
        System.out.println("*TRANSACTION BEGIN*");
    }

    @AfterReturning("transactionAnnotated()")
    public void commitTransaction() {
        System.out.println("*TRANSACTION COMMIT*");
    }

    @AfterThrowing("transactionAnnotated()")
    public void rollbackTransaction() {
        System.out.println("*TRANSACTION ROLLBACK*");
    }

}
