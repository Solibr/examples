package com.example.demo.commands;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


/**
 * Need to create separate commands to change names. For example add random part, or change prefix
 * (it could be used to replace current logic, if you replace "" to "newPrefix" (nothing to replace, just add a prefix))
 */
@Component
public class FilenamePrefixer implements CommandHandler {
    @Override
    public String getName() {
        return "file-prefixer";
    }

    @Override
    public void execute(String[] command) {
        if (command.length != 3 ) {
            System.out.println("Illegal arguments. \n 1. Prefix \n 2. Path to folder");
            return;
        }
        String prefix = command[1];
        Path path = Paths.get(command[2]);
        try {
            DirectoryStream<Path> paths =  Files.newDirectoryStream(path);
            for (Path p : paths) {
                String newName = prefix + p.getFileName();
                Path newPath = Paths.get(p.getParent().toString() + "/" + newName);
                Files.move(p, newPath);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done!");

    }
}
