package com.example.SpringDataH2Relationship.oneToMany;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.context.annotation.Profile;

import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    //@Cascade(org.hibernate.annotations.CascadeType.ALL/*{CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}*/)
    private Director director;

    public Movie(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ", Director: " + director.getName();
    }

    // Very important to define this, if we store data in Set
    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}
