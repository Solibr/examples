package com.example.SpringDataH2Relationship.oneToOne;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    // if on other side in @JoinColumn, referencedColumnName we defined field that isn't id, that filed should have unique constraint
    @Column(name = "some_id", unique = true)
    private Long someId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // If there would not be defined CascadeType at all, there will be a TransientPropertyValueException
    // We need to define CascadeType.PERSIST at least on one side to not get an Exception
    @OneToOne(mappedBy = "person", cascade = CascadeType.PERSIST)
    private Passport passport;
}
