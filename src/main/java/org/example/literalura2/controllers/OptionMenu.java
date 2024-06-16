package org.example.literalura2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.regex.Pattern;

@Component
public class OptionMenu {
    String regExp = "[0-9]";
    String regExp2 = "^[0-9]{4}$";
    Pattern pattern = Pattern.compile(regExp);
    Pattern pattern2 = Pattern.compile(regExp2);

    private final Scanner sc = new Scanner(System.in);
    private final BuscarLibro buscarLibro;
    private final ShowLibros showLibros;
    private final ShowAutores showAutores;
    private final ShowAuthorsByYear showAuthorsByYear;
    private final ShowByLanguage showByLanguage;
    private final ShowStillAlive showStillAlive;

    @Autowired
    public OptionMenu(BuscarLibro buscarLibro, ShowLibros showLibros, ShowAutores showAutores,
                      ShowAuthorsByYear showAuthorsByYear, ShowByLanguage showByLanguage,
                      ShowStillAlive showStillAlive) {
        this.buscarLibro = buscarLibro;
        this.showLibros = showLibros;
        this.showAutores = showAutores;
        this.showAuthorsByYear = showAuthorsByYear;
        this.showByLanguage = showByLanguage;
        this.showStillAlive = showStillAlive;
    }

    public void mainMenu() {
        System.out.println("\nBienvenido al menu principal, selecciona la opcion deseada\n");
        String menu = """
                1. Buscar libro por titulo
                2. Ver libros registrados
                3. Ver autores registrados
                4. Ver autores en determinado año
                5. Ver libros por idioma
                6. Ver autores vivos en determinado año
                0. Salir
                """;

        System.out.println(menu);

        optionValidation(sc.next());
    }

    private void optionValidation(String optionString) {
        if (pattern.matcher(optionString).matches()) {
            int option = Integer.parseInt(optionString);
            handleOptionSelected(option);
        } else {
            System.out.println("Opción no permitida, ingresa el número de la opción");
            mainMenu();
        }
    }

    private void handleOptionSelected(int option) {
        switch (option) {
            case 1:
                buscarLibro.buscarLibroWeb();
                continueMenu();
                break;
            case 2:
                showLibros.LibrosGuardados();
                continueMenu();
                break;
            case 3:
                showAutores.AutoresRegistrados();
                continueMenu();
                break;
            case 4:
                yearValidation();
                continueMenu();
                break;
            case 5:
                languageValidation();
                continueMenu();
                break;
            case 6:
                aliveAuthorsValidation();
                continueMenu();
                break;
            case 0:
                System.out.println("Usted a salido del menu");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                mainMenu();
                break;
        }
    }

    private void continueMenu() {
        System.out.println("\nDeseas continuar? (S/N)");
        String option = sc.next();
        if (option.equalsIgnoreCase("S")) {
            mainMenu();
        } else {
            System.out.println("Usted a salido del menu");
            System.exit(0);
        }
    }

    private void yearValidation() {
        System.out.println("Ingrese al año de referencia\n");
        String year = sc.next();

        if (pattern2.matcher(year).matches()) {
            int yearInt = Integer.parseInt(year);
            showAuthorsByYear.authorsByYear(yearInt);
        } else {
            System.out.println("Ingresar unicamente numeros para la busqueda");
            yearValidation();
        }

    }

    private void languageValidation() {
        System.out.println("Seleccione un lenguaje");
        String options = """
                1. Español
                2. Ingles
                3. Frances
                4. Portuges
                """;
        System.out.println(options);
        String option = sc.next();
        String seleccion = "";

        if (pattern.matcher(option).matches()) {
            switch (Integer.parseInt(option)) {
                case 1:
                    seleccion = "SPANISH";
                    break;
                case 2:
                    seleccion = "ENGLISH";
                    break;
                case 3:
                    seleccion = "FRENCH";
                    break;
                case 4:
                    seleccion = "PORTUGUESE";
                    break;
                default:
                    System.out.println("Eleccion Incorrecta\n");
                    languageValidation();
                    break;
            }

            showByLanguage.showByLanguage(seleccion);

        } else {
            System.out.println("Option no valida");
            languageValidation();
        }
    }

    private void aliveAuthorsValidation() {
        System.out.println("Ingrese el año de referencia\n");
        String year = sc.next();
        if (pattern2.matcher(year).matches()) {
            int yearInt = Integer.parseInt(year);
            showStillAlive.authorStillAlive(yearInt);
        } else {
            System.out.println("Ingresar unicamente numeros para la busqueda");
            aliveAuthorsValidation();
        }

    }

}
