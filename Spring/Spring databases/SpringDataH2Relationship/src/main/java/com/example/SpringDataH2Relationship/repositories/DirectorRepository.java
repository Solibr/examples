package com.example.SpringDataH2Relationship.repositories;

import com.example.SpringDataH2Relationship.oneToMany.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {
}
