package com.example.SpringDataH2Relationship.idTest;

import org.springframework.data.repository.CrudRepository;

public interface CatRepo extends CrudRepository<Cat, Long> {
}
