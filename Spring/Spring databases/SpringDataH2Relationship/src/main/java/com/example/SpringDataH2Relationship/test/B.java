package com.example.SpringDataH2Relationship.test;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
public class B {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "a_id")
    private A a;

    public B(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
