package com.example.SpringDataH2Relationship.oneToOne;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private String number;

    // If there would not be defined CascadeType at all, there will be a TransientPropertyValueException
    // We need to define CascadeType.PERSIST at least on one side to not get an Exception
    @OneToOne(cascade = CascadeType.PERSIST)

    // by default referencedColumnName is field which marked by @Id
    @JoinColumn(name = "person_id"/*, referencedColumnName = "some_id"*/)
    private Person person;

    public Passport(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }

}
