package org.example.literalura2.controllers;

import org.example.literalura2.entities.Book;
import org.example.literalura2.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class ShowLibros {

    private List<Book> libros;
    private final BookService bookService;

    @Autowired
    public ShowLibros(BookService bookService) {
        this.bookService = bookService;
    }


    public void LibrosGuardados(){
        libros = bookService.findAll();

        libros.stream()
                .sorted(Comparator.comparing(Book::getId))
                .forEach(System.out::println);
    }


}
