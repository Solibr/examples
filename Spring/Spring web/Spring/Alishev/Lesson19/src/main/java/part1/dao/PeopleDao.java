package part1.dao;

import org.springframework.stereotype.Component;
import part1.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDao {
    private List<Person> people = new ArrayList<>();
    private int lastId;
    private Connection connection;

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:postgresql:mydb", "postgres", "testtest");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }
    }

    public List<Person> getList() {

        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from shit;");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                people.add(new Person(name, id, age, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public Person get(int id) {
        Person person = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from shit where id = " + id + ";");

            resultSet.next();
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String email = resultSet.getString("email");
            person = new Person(name, id, age, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into shit(name, age, email) values ('" + person.getName() + "', " + person.getAge() + ",'" + person.getEmail() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(int id, Person updatedPerson) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE shit SET name = '" + updatedPerson.getName() +"', age = " + updatedPerson.getAge() + ", email = '" + updatedPerson.getEmail() + "' WHERE id = " + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("delete from shit where id = " + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
