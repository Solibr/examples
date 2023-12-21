package com.example.SpringDataH2Relationship.repositories;

import com.example.SpringDataH2Relationship.manyToMany.Film;
import com.example.SpringDataH2Relationship.oneToMany.Movie;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
}
