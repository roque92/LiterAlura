package org.example.literalura2.controllers;

import org.example.literalura2.entities.Author;
import org.example.literalura2.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowStillAlive {
    private List<Author> authors;
    private final AuthorRepository authorRepository;

    @Autowired
    public ShowStillAlive(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void authorStillAlive (int year) {
        System.out.println("Los autores que estan vivos segun el año " + year + " son:\n");

        authors = authorRepository.findByAliveYear(year);
        authors.forEach(System.out::println);
    }
}
