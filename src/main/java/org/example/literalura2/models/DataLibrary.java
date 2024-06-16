package org.example.literalura2.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataLibrary(
        @JsonAlias("results")
        List<DataBook> datosLibros
) {
}
