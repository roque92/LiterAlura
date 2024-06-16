package org.example.literalura2;

import org.example.literalura2.controllers.OptionMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class LiterAlura2Application {

    public static void main(String[] args) {
        SpringApplication.run(LiterAlura2Application.class, args);
    }
}
