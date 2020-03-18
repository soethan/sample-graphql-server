package com.graphqlspringboot.samplegraphqlserver.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqlspringboot.samplegraphqlserver.model.Author;
import com.graphqlspringboot.samplegraphqlserver.model.Book;
import com.graphqlspringboot.samplegraphqlserver.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookResolver implements GraphQLResolver<Book> {
    @Autowired
    private BookService bookService;

    public Author getAuthor(Book book) {
        return bookService.getAuthor(book);
    }
}
