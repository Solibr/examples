package com.example.demo;

import com.example.demo.commands.CommandHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class Config {

    @Bean("CommandMap")
    public Map<String, CommandHandler> getCommandsMap(List<CommandHandler> commandsList) {
        return commandsList.stream().collect(Collectors.toMap(commandHandler -> commandHandler.getName(), commandHandler -> commandHandler));
    }

}
