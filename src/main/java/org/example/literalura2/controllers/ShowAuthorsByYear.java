package org.example.literalura2.controllers;

import org.example.literalura2.entities.Author;
import org.example.literalura2.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowAuthorsByYear {
    private List<Author> aunVivo;
    private final AuthorRepository authorRepository;

    @Autowired
    public ShowAuthorsByYear(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void authorsByYear(int year){
        System.out.println("\nAutores encontrados\n");
        aunVivo = authorRepository.findByYear(year);
        aunVivo.forEach(System.out::println);
    }
}
