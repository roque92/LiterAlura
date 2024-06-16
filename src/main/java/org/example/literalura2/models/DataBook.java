package org.example.literalura2.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook(
        @JsonAlias("title")
        String title,
        @JsonAlias("authors")
        List<DataAuthor> autores,
        @JsonAlias("languages")
        List<String> idiomas,
        @JsonAlias("download_count")
        Integer descargas
) {
    @Override
    public String toString() {
        return "-----LIBRO-----" +
                "\nTitulo:" + title +
                "\nAutor: " + autores +
                "\nIdioma: " + idiomas +
                "\nDescargas: " + descargas +
                "\n------------\n";
    }
}
