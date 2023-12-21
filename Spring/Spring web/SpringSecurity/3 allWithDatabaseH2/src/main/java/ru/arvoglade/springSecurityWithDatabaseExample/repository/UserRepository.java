package ru.arvoglade.springSecurityWithDatabaseExample.repository;

import org.springframework.data.repository.CrudRepository;
import ru.arvoglade.springSecurityWithDatabaseExample.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);

}
