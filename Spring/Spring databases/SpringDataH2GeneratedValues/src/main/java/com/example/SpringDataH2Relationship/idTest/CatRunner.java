package com.example.SpringDataH2Relationship.idTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("idTest")
public class CatRunner implements CommandLineRunner {

    private final CatRepo catRepo;

    public CatRunner(CatRepo catRepo) {
        this.catRepo = catRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Cat tom = new Cat();
        tom.setName("Tom");
        //tom.setId(2L);

        catRepo.save(tom);

        catRepo.findAll().forEach(System.out::println);

        System.out.println("Id = 1: " + catRepo.findById(2L));
    }
}
