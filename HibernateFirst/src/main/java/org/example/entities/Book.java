package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Author> authors;

    public Book(String name) {
        this.name = name;
        this.authors = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }
}
