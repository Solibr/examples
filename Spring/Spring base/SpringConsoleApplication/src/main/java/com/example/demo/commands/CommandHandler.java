package com.example.demo.commands;

public interface CommandHandler {
    String getName();

    void execute(String[] command);
}
