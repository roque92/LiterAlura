package org.example.literalura2.controllers;

import org.example.literalura2.apiConnection.ClientApi;
import org.example.literalura2.entities.Author;
import org.example.literalura2.entities.Book;
import org.example.literalura2.models.DataBook;
import org.example.literalura2.models.DataLibrary;
import org.example.literalura2.services.AuthorService;
import org.example.literalura2.services.BookService;
import org.example.literalura2.services.ConverData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class BuscarLibro {

    private final Scanner scanner = new Scanner(System.in);
    private final ClientApi clientApi;
    private final ConverData converData;
    private final AuthorService authorService;
    private final BookService bookService;
    private final OptionMenu optionMenu;


    private List<Book> libros;

    @Autowired
    public BuscarLibro(ClientApi clientApi, ConverData converData, AuthorService authorService, BookService bookService, @Lazy OptionMenu optionMenu) {
        this.clientApi = clientApi;
        this.converData = converData;
        this.authorService = authorService;
        this.bookService = bookService;
        this.optionMenu =  optionMenu;

    }


    public void buscarLibroWeb() {
        System.out.println("Ingrese el nombre del libro a buscar\n");
        String tituloBuscado = scanner.nextLine();

        String encodedParam = URLEncoder.encode(tituloBuscado, StandardCharsets.UTF_8);

        // Obtener los datos de la API
        String json = clientApi.buscarLibro(encodedParam);

        // Convertir los datos a objetos
        DataLibrary apiDatos = converData.getData(json, DataLibrary.class);

        // Filtrar el primer libro encontrado
        Optional<DataBook> libroEncontrado = apiDatos.datosLibros().stream()
                .filter(libro -> libro.title().toLowerCase().contains(tituloBuscado.toLowerCase()))
                .findFirst();

        if (libroEncontrado.isPresent()) {
            DataBook dataBook = libroEncontrado.get();
            System.out.println("Titulo: " + dataBook.title());

            String authorName = dataBook.autores() != null ? dataBook.autores().getFirst().nombre() : "Desconocido";
            System.out.println("Autor: " + authorName);

            // Buscar autor por nombre en la base de datos
            Author author = dataBook.autores() != null ? new Author(dataBook.autores()) : null;
            Optional<Author> autorEncontrado = authorService.findByName(authorName);

            try {
                if (!autorEncontrado.isPresent()) {
                    authorService.save(author);
                }

                Optional<Book> existenciaLibro = bookService.findByTitle(dataBook.title());

                if (!existenciaLibro.isPresent()) {
                    Book book = new Book(dataBook);
                    book.setAutor(author);
                    bookService.save(book);
                } else {
                    System.out.println("El libro ya está registrado.");
                }
            } catch (Exception e) {
                System.out.println("\n*** Error al intentar guardar el libro y/o autor: " + e.getMessage() + " ***");
            }

        } else {
            System.out.println("\n*** Libro no encontrado. ***");
            optionMenu.continueMenu();
        }
        optionMenu.continueMenu();
    }
}
