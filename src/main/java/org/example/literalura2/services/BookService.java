package org.example.literalura2.services;

import org.example.literalura2.entities.Book;
import org.example.literalura2.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
