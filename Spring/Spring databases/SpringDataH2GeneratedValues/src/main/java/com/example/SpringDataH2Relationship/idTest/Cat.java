package com.example.SpringDataH2Relationship.idTest;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Cat {

    @Id

    // in default case (at least in my case it was like GenerationType.SEQUENCE with allocationSize=50)
    @GeneratedValue // In this case I have created id field this way: id bigint primary key. And I've created sequence: create sequence CAT_SEQ increment by 50;

    // Same, but here I defined allocationSize as 1. And this makes me define sequence explicitly
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "some")
    //@SequenceGenerator(name = "some", sequenceName = "CAT_SEQ", allocationSize = 1)

    // Other case. It's compatible with next table field creation: id bigint generated always as identity primary key. Don't need any sequence
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    public Cat(String name) {
        this.name = name;
    }
}
