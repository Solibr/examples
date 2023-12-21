package com.example.profileapplicationtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${val.1}")              // Value указывается у поля класса - если значения нет, ошибка будет в момент запуска приложения
    private String val1;
    @Value("${val.2}")
    private String val2;
    @Value("${val.3}")
    private String val3;


    @GetMapping("/")
    public String getText() {
        return val1.concat(val2).concat(val3);
    }

    @GetMapping("/hello")
    public String getText2(@Value("${word}") String word) {     // Value указывается в параметре - если значения нет, ошибка будет в момент вызова метода
        return "Hello ".concat(word);
    }
}
