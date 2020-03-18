package com.graphqlspringboot.samplegraphqlserver.repository;

import com.graphqlspringboot.samplegraphqlserver.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { }
