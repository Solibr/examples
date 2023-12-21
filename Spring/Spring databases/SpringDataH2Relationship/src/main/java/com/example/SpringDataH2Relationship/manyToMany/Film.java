package com.example.SpringDataH2Relationship.manyToMany;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.context.annotation.Profile;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue
    private Long id;


    private String name;

    @ManyToMany(mappedBy = "films", fetch = FetchType.EAGER)
    @Cascade(CascadeType.PERSIST)
    private Set<Actor> actors = new HashSet<>();

    public Film(String name) {
        this.name = name;
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        actors.forEach(a -> {
            sb.append("\n\t");
            sb.append(a.getName());
        });
        return sb.toString();
    }
}
