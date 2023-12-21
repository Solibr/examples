package part1.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    @NotEmpty(message = "Name should not be empty")
    @Size(message = "Name should contain than 50 characters", min=0, max=50)
    private String name;
    private int id;
    @Min(value=0, message="Age should be positive")
    private int age;
    @Email(message="Email is incorrect")
    @NotEmpty(message = "Email should not be empty")
    private String email;

    public Person() {}

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Person(String name, int id, int age, String email) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
