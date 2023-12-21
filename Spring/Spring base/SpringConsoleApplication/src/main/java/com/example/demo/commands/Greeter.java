package com.example.demo.commands;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Greeter implements CommandHandler {
    @Override
    public String getName() {
        return "greet";
    }

    @Override
    public void execute(String[] command) {
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
