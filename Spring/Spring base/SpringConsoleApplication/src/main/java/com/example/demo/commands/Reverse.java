package com.example.demo.commands;

import org.springframework.stereotype.Component;

@Component
public class Reverse implements CommandHandler {
    @Override
    public String getName() {
        return "reverse";
    }

    @Override
    public void execute(String[] command) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < command.length - 1; i++) {
            stringBuilder.append(command[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.append(command[command.length - 1]);

        System.out.println(stringBuilder.reverse().toString());
    }
}
