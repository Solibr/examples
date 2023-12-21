package com.example.demo.controllers;

import jdk.jfr.ContentType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/hello2")
    public Object hello2() {
        return "Hello world";
    }

    @GetMapping("/hello3")
    public Object hello3() {
        return new Object() {
            String message = "hello";
            public String getMessage() {
                return message;
            }
        };
    }


}
