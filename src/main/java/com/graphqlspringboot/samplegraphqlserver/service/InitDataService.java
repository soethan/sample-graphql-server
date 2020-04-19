package com.graphqlspringboot.samplegraphqlserver.service;

import com.graphqlspringboot.samplegraphqlserver.model.Author;
import com.graphqlspringboot.samplegraphqlserver.model.Book;
import com.graphqlspringboot.samplegraphqlserver.model.User;
import com.graphqlspringboot.samplegraphqlserver.repository.AuthorRepository;
import com.graphqlspringboot.samplegraphqlserver.repository.BookRepository;
import com.graphqlspringboot.samplegraphqlserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InitDataService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public void init() {
        List<User> userList = Arrays.asList(
                new User("steven", "1234"),
                new User("michael", "1234")
        );
        userRepository.saveAll(userList);

        List<Author> authorList = Arrays.asList(
                new Author("Steven", "Soe"),
                new Author("Author", "111"),
                new Author("Author", "222"),
                new Author("Author", "333"),
                new Author("Author", "444"),
                new Author("Author", "555")
        );
        authorRepository.saveAll(authorList);

        List<Book> bookList = Arrays.asList(
                new Book("GraphQL for Beginners", "100001", 888, authorList.get(1)),
                new Book("Java for Beginners", "100002", 888, authorList.get(2)),
                new Book("Python for Beginners", "100003", 888, authorList.get(3)),
                new Book("C# for Beginners", "100004", 888, authorList.get(4)),
                new Book("ReactJs for Beginners", "100005", 888, authorList.get(5))
        );

        bookRepository.saveAll(bookList);
    }
}
