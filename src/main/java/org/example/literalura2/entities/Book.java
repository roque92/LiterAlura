package org.example.literalura2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.literalura2.models.DataBook;
import org.example.literalura2.models.Language;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "libros")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Author autor;

    @Enumerated (EnumType.STRING)
    private Language idioma;

    private int descargas;

    public Book(DataBook dataBook) {
        this.titulo = dataBook.title();
        this.idioma = Language.fromString(dataBook.idiomas().get(0));
        this.descargas = dataBook.descargas();
    }

    public Author getAuthor() {
        return autor;
    }
}
