package com.gorbunov.view;

import com.gorbunov.services.ClientService;
import com.gorbunov.validator.BusinessException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {

    private final BufferedReader br;
    private ClientService clientService;

    public MainMenu(BufferedReader br, ClientService clientService) {
        this.br = br;
        this.clientService = clientService;
    }

    public void showMenu() throws IOException, BusinessException {
        boolean isRunning = true;
        while(isRunning) {

            System.out.println("\n1. Admin menu");
            System.out.println("2. Client menu");
            System.out.println("0. Exit");

            System.out.print("\nSelect your choice => ");
            String input = br.readLine();

            switch (input) {
                case "1":
                    System.out.println("Admin menu");
                    new AdminMenu(br, clientService).adminMenu();
                    break;
                case "2":
                    System.out.println("Client menu");
                    new ClientMenu(br, clientService).clientMenu();
                    break;
                case "0":
                    System.out.println("Exit...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
