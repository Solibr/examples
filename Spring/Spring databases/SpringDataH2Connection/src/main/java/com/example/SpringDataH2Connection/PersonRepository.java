package com.example.SpringDataH2Connection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
