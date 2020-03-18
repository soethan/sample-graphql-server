package com.graphqlspringboot.samplegraphqlserver.service;

import com.graphqlspringboot.samplegraphqlserver.exception.IdNotFoundException;
import com.graphqlspringboot.samplegraphqlserver.model.Author;
import com.graphqlspringboot.samplegraphqlserver.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (!author.isPresent()) {
            throw new IdNotFoundException("Author does not exist", id);
        }
        return author.get();
    }

    public List<Author> findAuthorByFirstName(String name) {
        List<Author> authorList = authorRepository.findByFirstNameLike(name);
        return authorList;
    }

    public long getCount() {
        return authorRepository.count();
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);
        return author;
    }
}
