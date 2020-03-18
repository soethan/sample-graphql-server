package com.graphqlspringboot.samplegraphqlserver.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqlspringboot.samplegraphqlserver.model.Author;
import com.graphqlspringboot.samplegraphqlserver.model.Book;
import com.graphqlspringboot.samplegraphqlserver.service.AuthorService;
import com.graphqlspringboot.samplegraphqlserver.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    public Author newAuthor(String firstName, String lastName) {
        return authorService.newAuthor(firstName, lastName);
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        return bookService.newBook(title, isbn, pageCount, authorId);
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        return bookService.updateBookPageCount(pageCount, id);
    }

    public boolean deleteBook(Long id) {
        return  bookService.deleteBook(id);
    }
}
