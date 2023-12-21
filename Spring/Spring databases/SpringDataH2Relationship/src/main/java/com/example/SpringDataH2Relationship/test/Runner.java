package com.example.SpringDataH2Relationship.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
@Profile("test")
public class Runner implements CommandLineRunner {

    private final AR ar;
    private final BR br;
    private final Extractor e;

    public Runner(AR ar, BR br, Extractor e) {
        this.ar = ar;
        this.br = br;
        this.e = e;
    }


    @Override
    public void run(String... args) throws Exception {

        storeData();


        e.extract().forEach(b -> {
            System.out.println(b.getName());
        });

    }



    public void storeData() {
        A a = new A("MAIN");
        a = ar.save(a);
        B b = new B("Some");
        b.setA(a);
        br.save(b);
        b = new B("Shit");
        b.setA(a);
        br.save(b);
    }
}
