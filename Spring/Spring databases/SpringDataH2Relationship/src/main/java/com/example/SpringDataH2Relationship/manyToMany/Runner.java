package com.example.SpringDataH2Relationship.manyToMany;

import com.example.SpringDataH2Relationship.repositories.ActorRepository;
import com.example.SpringDataH2Relationship.repositories.FilmRepository;
import com.example.SpringDataH2Relationship.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("ManyToMany")
public class Runner implements CommandLineRunner {

    private final ActorRepository actorRepository;
    private final FilmRepository filmRepository;

    public Runner(ActorRepository actorRepository, FilmRepository filmRepository) {
        this.actorRepository = actorRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("\nBefore update");
        actorRepository.findAll().forEach(System.out::println);
        filmRepository.findAll().forEach(System.out::println);
        System.out.println("\n");

        Actor carrey = new Actor("Jim Carrey");
        Film kickAss2 = new Film("Kick-Ass 2");
        Film theMask = new Film("The Mask");
        Actor moretz = new Actor("Chloë Grace Moretz");

        /*theMask = filmRepository.findById(1L).get();
        kickAss2 = filmRepository.findById(2L).get();*/


        carrey.addFilm(theMask);
        carrey.addFilm(kickAss2);
        moretz.addFilm(kickAss2);
//        theMask.addActor(carrey);
//        kickAss2.addActor(moretz);
//        kickAss2.addActor(carrey);


        //actorRepository.save(carrey);
        //actorRepository.save(moretz);
        // if we would try to save entities separately, we will get an Exception

        // And line below works perfectly
        actorRepository.saveAll(List.of(carrey, moretz));


        System.out.println("\nAfter update");
        System.out.println("\nActors --------");
        actorRepository.findAll().forEach(System.out::println);
        System.out.println("\nFilms --------");
        filmRepository.findAll().forEach(System.out::println);
        System.out.println("\n");

    }
}
