package com.example.SpringDataH2Relationship.repositories;

import com.example.SpringDataH2Relationship.oneToMany.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
