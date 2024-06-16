package org.example.literalura2.configuration;

import org.example.literalura2.controllers.OptionMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
    private final OptionMenu optionMenu;

    public AppRunner(OptionMenu optionMenu) {
        this.optionMenu = optionMenu;
    }

    @Override
    public void run(String... args) throws Exception {
        optionMenu.mainMenu();
    }
}
