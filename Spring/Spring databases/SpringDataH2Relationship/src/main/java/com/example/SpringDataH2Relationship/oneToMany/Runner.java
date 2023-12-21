package com.example.SpringDataH2Relationship.oneToMany;

import com.example.SpringDataH2Relationship.repositories.DirectorRepository;
import com.example.SpringDataH2Relationship.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("OneToMany")
public class Runner implements CommandLineRunner {

    private final DirectorRepository directorRepository;

    private final MovieRepository movieRepository;

    public Runner(DirectorRepository directorRepository, MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\nBefore update");
        directorRepository.findAll().forEach(System.out::println);
        movieRepository.findAll().forEach(System.out::println);
        System.out.println("\n");

        Director director = new Director("Tarantino");
        Movie movie1 = new Movie("Kill Bill");
        Movie movie2 = new Movie("Hateful Eight");

        // ===== CASE 0 =====
        // The shortest way to save all entities and their relations is to set relations on owned side and save these entities;
        movie1.setDirector(director);
        movie2.setDirector(director);
        movieRepository.saveAll(List.of(movie1, movie2)); // in this case we must use saveAll to avoid Exception


        // ===== CASE 1 =====
        // If we define relationship from each side ...
/*
        director.addMovie(movie1);
        director.addMovie(movie2);
        movie1.setDirector(director);
        movie2.setDirector(director);
        // ... we can save any entity, and this will save data correctly
        //directorRepository.save(director);              // this
        movieRepository.save(movie1);                 // or this. Result is same
*/


        // ===== CASE 2 =====
        // If we define relationship only from "many" side ...
/*
        movie1.setDirector(director);
        movie2.setDirector(director);
        //directorRepository.save(director);                      // this will not save movies at all. only director
        movieRepository.save(movie1);                             // this will save only movie1
        //movieRepository.save(movie2);                           // error. Don't know why
*/

        // ===== CASE 3 =====
        // If we define relationship only from "one" side ...
        /*director.addMovie(movie1);
        director.addMovie(movie2);
        //directorRepository.save(director);                      // this will save all entities, but without relations (movie.director_id will be null)
        movieRepository.save(movie1);                            // this will be even worse (only movie1 without relations)
        */

        System.out.println("\nAfter update");
        System.out.println("\n--- Directors ---");
        directorRepository.findAll().forEach(System.out::println);
        System.out.println("\n--- Movies ---");
        movieRepository.findAll().forEach(System.out::println);
        System.out.println("\n");

    }

}
