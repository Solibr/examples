package com.example.SpringDataH2Relationship.test;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "parent_id")
    private PostComment parentPostComment;

    public PostComment(String name) {
        this.name = name;
    }
}
