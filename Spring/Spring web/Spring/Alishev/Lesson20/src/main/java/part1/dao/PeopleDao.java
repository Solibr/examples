package part1.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import part1.model.Person;
import java.util.List;
import java.util.Optional;

@Component
public class PeopleDao {
    private JdbcTemplate jdbcTemplate;

    public PeopleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> getList() {
        return jdbcTemplate.query("select * from shit", new PersonRowMapper());
    }

    public Person get(int id) {

        return jdbcTemplate.query("select * from shit where id = ?", new BeanPropertyRowMapper<Person>(Person.class), id).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("insert into shit(name, age, email) values (?,?,?)", person.getName(), person.getAge(), person.getEmail());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE shit SET name = ?, age = ?, email = ? WHERE id = ?;", updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(), updatedPerson.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from shit where id = ?;", id);
    }

    public Optional<Person> emailPresent(String email) {
        return jdbcTemplate.query("select * from shit where email = ?", new BeanPropertyRowMapper<>(Person.class), email)
                .stream().findAny();
    }

}
