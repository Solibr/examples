package com.example.SpringDataH2Relationship.oneToMany;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Director {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    //@Cascade({org.hibernate.annotations.CascadeType.ALL})
    private Set<Movie> movies = new HashSet<>();

    public Director(String name) {
        this.name = name;
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name);
        movies.forEach(m -> {
            stringBuilder.append("\n\t");
            stringBuilder.append(m.getName());
        });
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}
