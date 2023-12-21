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
            ResultSet resultSet = connection.prepareStatement("select * from shit;").executeQuery();

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
            PreparedStatement preparedStatement = connection.prepareStatement("select * from shit where id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

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
            PreparedStatement preparedStatement = connection.prepareStatement("insert into shit(name, age, email) values (?,?,?);");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(int id, Person updatedPerson) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE shit SET name = ?, age = ?, email = ? WHERE id = ?;");
            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setInt(2, updatedPerson.getAge());
            preparedStatement.setString(3, updatedPerson.getEmail());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from shit where id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
