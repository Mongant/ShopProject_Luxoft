package com.gorbunov;

import com.gorbunov.view.MainMenu;
import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.showMenu();
    }
}