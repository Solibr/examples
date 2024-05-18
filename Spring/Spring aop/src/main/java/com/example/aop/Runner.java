package com.example.aop;

import com.example.aop.code.SomeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Runner implements CommandLineRunner {

    @Autowired
    private SomeService someService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started");
        someService.doSomeServiceLogic();
    }

}
