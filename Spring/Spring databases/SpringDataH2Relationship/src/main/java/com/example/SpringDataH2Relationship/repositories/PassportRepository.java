package com.example.SpringDataH2Relationship.repositories;

import com.example.SpringDataH2Relationship.oneToOne.Passport;
import org.springframework.data.repository.CrudRepository;

public interface PassportRepository extends CrudRepository<Passport, Long> {
}
