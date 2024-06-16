package org.example.literalura2.controllers;

import java.util.Comparator;
import java.util.List;
import org.example.literalura2.entities.Author;
import org.example.literalura2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowAutores {

    private List<Author> autores;
    private final AuthorService authorService;

    @Autowired
    public ShowAutores(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void AutoresRegistrados(){

        autores = authorService.findAll();

        autores.stream()
                .sorted(Comparator.comparing(Author::getId))
                .forEach(System.out::println);


    }
}
