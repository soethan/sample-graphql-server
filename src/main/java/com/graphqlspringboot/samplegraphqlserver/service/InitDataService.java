package com.graphqlspringboot.samplegraphqlserver.service;

import com.graphqlspringboot.samplegraphqlserver.model.Author;
import com.graphqlspringboot.samplegraphqlserver.model.Book;
import com.graphqlspringboot.samplegraphqlserver.repository.AuthorRepository;
import com.graphqlspringboot.samplegraphqlserver.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InitDataService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public void init() {
        List<Author> authorList = Arrays.asList(
                new Author("Steven", "Soe"),
                new Author("Author", "111"),
                new Author("Author", "222"),
                new Author("Author", "333"),
                new Author("Author", "444"),
                new Author("Author", "555")
        );
        authorRepository.saveAll(authorList);

        bookRepository.save(new Book("GraphQL for Beginners", "0123456789", 888, authorList.get(0)));
    }
}
