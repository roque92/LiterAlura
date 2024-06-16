package org.example.literalura2.repositories;

import org.example.literalura2.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository <Book, Long>{
    @Query("SELECT b FROM Book b WHERE :language = '' OR UPPER(b.idioma) = UPPER(:language)")
    List<Book> findByLanguage (String language);

    @Query("SELECT b FROM Book b WHERE LOWER(b.titulo) LIKE LOWER(concat('%',:title,'%'))")
    Optional<Book> findByTitle(String title);


}
