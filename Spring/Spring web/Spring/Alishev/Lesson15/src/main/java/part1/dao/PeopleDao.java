package part1.dao;

import org.springframework.stereotype.Component;
import part1.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDao {
    private List<Person> people = new ArrayList<>();
    private int lastId;

    {
        people.add(new Person("Tim", ++lastId));
        people.add(new Person("Kim", ++lastId));
        people.add(new Person("Jim", ++lastId));
    }

    public List<Person> getList() {
        return people;
    }

    public Person get(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++lastId);
        people.add(person);
    }

}
