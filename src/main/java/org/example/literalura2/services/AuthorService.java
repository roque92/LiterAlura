package org.example.literalura2.services;

import org.example.literalura2.entities.Author;
import org.example.literalura2.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public void save (Author author) {
        authorRepository.save(author);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public List<Author> findByYear(Integer year) {
        return authorRepository.findByYear(year);
    }

    public Optional<Author> findByName(String nombre) {
        return authorRepository.findByName(nombre);
    }

}
