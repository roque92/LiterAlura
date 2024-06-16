package org.example.literalura2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.literalura2.models.DataAuthor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "autores")
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    private int nacimiento;
    private int muerte;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> libros = new ArrayList<>();

    public Author(List<DataAuthor> author) {
        this.nombre = author.getFirst().nombre();
        this.nacimiento = author.getFirst().nacimiento();
        this.muerte = author.getFirst().muerte();
    }
}
