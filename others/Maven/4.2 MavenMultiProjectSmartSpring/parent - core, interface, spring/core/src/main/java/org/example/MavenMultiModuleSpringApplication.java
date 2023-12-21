package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MavenMultiModuleSpringApplication implements CommandLineRunner {

    @Autowired
    private Module module;

    public static void main(String[] args) {

        SpringApplication.run(MavenMultiModuleSpringApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world");

        System.out.println(module.getName());
    }
}
