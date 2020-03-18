package com.graphqlspringboot.samplegraphqlserver.service;

import com.graphqlspringboot.samplegraphqlserver.exception.IdNotFoundException;
import com.graphqlspringboot.samplegraphqlserver.model.Author;
import com.graphqlspringboot.samplegraphqlserver.model.Book;
import com.graphqlspringboot.samplegraphqlserver.repository.AuthorRepository;
import com.graphqlspringboot.samplegraphqlserver.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent()) {
            throw new IdNotFoundException("The book does not exist", id);
        }
        return book.get();
    }

    public Author getAuthor(Book book) {
        Long authorId = book.getAuthor().getId();
        Optional<Author> author = authorRepository.findById(authorId);
        if (!author.isPresent()) {
            throw new IdNotFoundException("Author does not exist", authorId);
        }
        return author.get();
    }

    public long getCount() {
        return bookRepository.count();
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        if (!author.isPresent()) {
            throw new IdNotFoundException("Author does not exist", authorId);
        }
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(!book.isPresent()) {
            throw new IdNotFoundException("The book to be updated does not exist", id);
        }
        Book bookToUpdate = book.get();
        bookToUpdate.setPageCount(pageCount);

        bookRepository.save(bookToUpdate);

        return bookToUpdate;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }
}
