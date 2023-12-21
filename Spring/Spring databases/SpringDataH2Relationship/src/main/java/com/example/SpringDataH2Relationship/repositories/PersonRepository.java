package com.example.SpringDataH2Relationship.repositories;


import com.example.SpringDataH2Relationship.oneToOne.Person;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
