package com.example.SpringDataH2Relationship.test;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class A {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "a", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<B> bList = new HashSet<>();

    public A(String name) {
        this.name = name;
    }

    private void addB(B b) {
        this.bList.add(b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        bList.forEach(b -> {
            sb.append("\n\t");
            sb.append(b.getName());
        });
        return sb.toString();
    }
}
