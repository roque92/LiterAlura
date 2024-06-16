package org.example.literalura2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.regex.Pattern;

@Component
public class OptionMenu {
    String regExp = "[0-9]";
    Pattern pattern = Pattern.compile(regExp);

    private final Scanner sc = new Scanner(System.in);
    private final BuscarLibro buscarLibro;

    @Autowired
    public OptionMenu(BuscarLibro buscarLibro) {
        this.buscarLibro = buscarLibro;
    }

    public void mainMenu() {
        System.out.println("\nBienvenido al menu principal, selecciona la opcion deseada\n");
        System.out.println("1. Buscar libro por titulo");
        System.out.println("2. Ver libros registrados");
        System.out.println("3. Ver autores registrados");
        System.out.println("4. Ver autores vivos en un determinado año");
        System.out.println("5. Ver libros por idioma");
        System.out.println("0. Salir");

        optionValidation(sc.next());
    }

    public void optionValidation(String optionString) {
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
                break;
            case 2:
                //llamar Base Datos libros registrados
                break;
            case 3:
                //llamar Base Datos autores registrados
                break;
            case 4:
                //llamar Base Datos autores vivos en un determinado año
                break;
            case 5:
                //llamar Base Datos libros por idioma
                break;
            case 0:
                System.out.println("Usted a salido del menu");
                System.exit(0);
            default:
                System.out.println("Invalid option");
                mainMenu();
        }
    }

    public void continueMenu() {
        System.out.println("\nDeseas continuar? (S/N)");
        String option = sc.next();
        if (option.equalsIgnoreCase("S")) {
            mainMenu();
        } else {
            System.out.println("Usted a salido del menu");
            System.exit(0);
        }
    }
}
