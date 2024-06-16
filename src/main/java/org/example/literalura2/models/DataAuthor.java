package org.example.literalura2.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAuthor(
        @JsonAlias("name")
        String nombre,
        @JsonAlias("birth_year")
        int nacimiento,
        @JsonAlias("death_year")
        int muerte
) {
    @Override
    public String toString() {
        return "\nNombre: " + nombre +
                "\nFecha de nacimiento: " + nacimiento +
                "\nFecha de muerte: " + muerte + "\n";
    }
}
