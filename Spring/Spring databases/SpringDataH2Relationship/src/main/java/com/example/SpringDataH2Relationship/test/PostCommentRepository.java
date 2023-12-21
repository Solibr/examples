package com.example.SpringDataH2Relationship.test;

import org.springframework.data.repository.CrudRepository;

public interface PostCommentRepository extends CrudRepository<PostComment, Integer> {
}
