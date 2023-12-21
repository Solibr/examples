package com.example.demo.commands;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GetValue implements CommandHandler {

    @Value("${some.value}")
    private String value;

    @Override
    public String getName() {
        return "get-value";
    }

    @Override
    public void execute(String[] command) {
        System.out.println("Value: " + value);
    }
}
