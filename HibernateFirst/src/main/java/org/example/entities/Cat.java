package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cats", indexes = @Index(columnList = "catname"))
public class Cat {

    @Id
    @GeneratedValue
    private Long id;

    //@NaturalId
    @Column(name = "catname")
    private String name;

    public Cat() {}

    public Cat(String name) {
        this.name = name;
    }

    public Cat(Long id, String name) {
        this.id = id;
        this.name = name;
    }


}
