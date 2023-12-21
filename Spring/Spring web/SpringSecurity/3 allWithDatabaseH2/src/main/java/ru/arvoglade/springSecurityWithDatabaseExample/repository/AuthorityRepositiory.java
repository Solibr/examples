package ru.arvoglade.springSecurityWithDatabaseExample.repository;

import org.springframework.data.repository.CrudRepository;
import ru.arvoglade.springSecurityWithDatabaseExample.entities.Authority;

public interface AuthorityRepositiory extends CrudRepository<Authority, String> {
}
