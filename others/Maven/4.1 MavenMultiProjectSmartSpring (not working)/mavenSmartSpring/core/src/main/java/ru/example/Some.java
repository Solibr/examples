package ru.example;

import org.springframework.stereotype.Component;

@Component
public class Some implements Module {
    @Override
    public String getName() {
        return "module some";
    }
}
