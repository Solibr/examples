package com.example.SpringDataH2Relationship.repositories;

import com.example.SpringDataH2Relationship.manyToMany.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Long> {
}
