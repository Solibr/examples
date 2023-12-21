package part1.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import part1.model.Person;
import java.util.List;

@Component
public class PeopleDao {
    private JdbcTemplate jdbcTemplate;

    // внедряем JdbcTemplate в класс, где идёт работа с БД
    public PeopleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // #new - PersonRowMapper() - предоставляет правила того как преобразуются данные из БД в поля объекта и наоборот. Нужно реализовать самостоятельно один раз, но потом можно использовать во всех методах
    public List<Person> getList() {
        return jdbcTemplate.query("select * from shit", new PersonRowMapper());
    }

    public Person get(int id) {

        // #new - BeanPropertyRowMapper<>() - уже существующий в библиотеке класс, который стандатным образом преобразует поля из БД в поля объекта и наоборот, если их имена совпадают
        // таким образом, это избавляет от необходимости реализовывать свой RowMapper
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

}
