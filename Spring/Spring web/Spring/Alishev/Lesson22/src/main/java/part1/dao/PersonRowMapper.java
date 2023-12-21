package part1.dao;

import org.springframework.jdbc.core.RowMapper;
import part1.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        //rs.next();
        person.setName(rs.getString("name"));
        person.setId(rs.getInt("id"));
        person.setAge(rs.getInt("age"));
        person.setEmail(rs.getString("email"));
        return person;
    }
}
