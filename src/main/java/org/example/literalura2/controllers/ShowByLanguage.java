package org.example.literalura2.controllers;

import org.example.literalura2.entities.Book;
import org.example.literalura2.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowByLanguage {
    private List<Book> libro;
    private final BookService bookService;

    @Autowired

    public ShowByLanguage(BookService bookService) {
        this.bookService = bookService;
    }

    public void showByLanguage(String language) {
        libro = bookService.findByLanguage(language);

        if (libro.isEmpty()) {
            System.out.println("No se encontraron libros con el idioma especificado");
        } else {
            System.out.println("Libros contrados: \n");
            libro.forEach(System.out::println);
        }
    }
}
