package ru.example;

import org.springframework.stereotype.Component;

@Component
public class Module4 implements Module {
    @Override
    public String getName() {
        return "module 4";
    }
}
