package com.graphqlspringboot.samplegraphqlserver.repository;

import com.graphqlspringboot.samplegraphqlserver.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByFirstNameLike(String firstName);
}
