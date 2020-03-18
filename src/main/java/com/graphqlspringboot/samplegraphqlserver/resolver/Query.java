package com.graphqlspringboot.samplegraphqlserver.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqlspringboot.samplegraphqlserver.model.Author;
import com.graphqlspringboot.samplegraphqlserver.model.Book;
import com.graphqlspringboot.samplegraphqlserver.service.AuthorService;
import com.graphqlspringboot.samplegraphqlserver.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    public Iterable<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    public Book findBookById(Long id) {
        return bookService.findBookById(id);
    }

    public long countBooks() {
        return bookService.getCount();
    }

    public Iterable<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }

    public Author findAuthorById(Long id) {
        return authorService.findAuthorById(id);
    }

    public List<Author> findAuthorByFirstName(String name) {
        return authorService.findAuthorByFirstName(name);
    }

    public long countAuthors() {
        return authorService.getCount();
    }
}
