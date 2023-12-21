package com.example.demo.commands;

import org.springframework.stereotype.Component;

@Component
public class Exit implements CommandHandler {
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public void execute(String[] command) {
        System.exit(0);
    }
}
