package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MavenMultiModuleSpringApplication implements CommandLineRunner {


    @Autowired
    private List<Module> moduleList;

    public static void main(String[] args) {

        SpringApplication.run(MavenMultiModuleSpringApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world");

        System.out.println("Found modules: " + moduleList.size());
        moduleList.forEach(module -> System.out.println("\t" + module.getName()));

    }
}
