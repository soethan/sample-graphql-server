package com.graphqlspringboot.samplegraphqlserver.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqlspringboot.samplegraphqlserver.model.Author;
import com.graphqlspringboot.samplegraphqlserver.model.Book;
import com.graphqlspringboot.samplegraphqlserver.model.User;
import com.graphqlspringboot.samplegraphqlserver.service.AuthorService;
import com.graphqlspringboot.samplegraphqlserver.service.BookService;
import com.graphqlspringboot.samplegraphqlserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    public User login(String userName, String password) {
        return userService.findUser(userName, password);
    }

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
