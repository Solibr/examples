package com.example.SpringDataH2Relationship.manyToMany;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.PERSIST)
    @JoinTable(name = "actor_film",
            joinColumns = {@JoinColumn(name = "actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id")})
    private Set<Film> films = new HashSet<>();

    public Actor(String name) {
        this.name = name;
    }

    public void addFilm(Film film) {
        this.films.add(film);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        films.forEach(f -> {
            sb.append("\n\t");
            sb.append(f.getName());
        });
        return sb.toString();
    }
}
