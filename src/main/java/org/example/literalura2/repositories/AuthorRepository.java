package org.example.literalura2.repositories;

import org.example.literalura2.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository <Author, Long>{

    @Query("SELECT a FROM Author a WHERE LOWER(a.nombre) LIKE LOWER(concat('%', :nombre, '%'))")
    Optional<Author> findByName(String nombre);

    @Query("SELECT a FROM Author a  WHERE a.nacimiento <= :year AND (a.muerte IS NULL OR a.muerte >= :year)")
    List<Author> findByYear(Integer year);

    @Query("SELECT a FROM Author a WHERE a.nacimiento >= :year AND a.muerte >= :year")
    List<Author> findByAliveYear(Integer year);
}
