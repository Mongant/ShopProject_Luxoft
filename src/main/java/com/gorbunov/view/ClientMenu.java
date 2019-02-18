package com.gorbunov.view;

import com.gorbunov.services.ClientService;
import com.gorbunov.validator.BusinessException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientMenu {

    private BufferedReader br;
    private ClientService clientService;

    public ClientMenu(BufferedReader br, ClientService clientService) {
        this.br = br;
        this.clientService = clientService;
    }

    public void clientMenu() throws IOException, BusinessException {
        boolean isRunning = true;
        clientOptions();

        while (isRunning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    System.out.println("Products");
                    unavailableItem();
                    break;
                case "2":
                    System.out.println("Shopping basket");
                    unavailableItem();
                    break;
                case "3":
                    System.out.println("Order");
                    unavailableItem();
                    break;
                case "0":
                    System.out.println("Main menu");
                    new MainMenu(br, clientService).showMenu();
                    break;
                default:
                    System.out.println("Wrong input, try again!");
                    clientMenu();
            }
        }
    }

    private void clientOptions() {
        System.out.println("\n1. Products");
        System.out.println("2. Shopping basket");
        System.out.println("3. Order");
        System.out.println("4. Modify information" );
        System.out.println("5. Delete client");
        System.out.println("0. Return in main menu");
    }

    private void unavailableItem() throws IOException, BusinessException {
        boolean isRunning = true;
        System.out.println("\nSection is under construction");

        while (isRunning) {
            System.out.println("0. Return in client menu");
            String input = br.readLine();
            switch (input) {
                case "0":
                    clientMenu();
                    break;
                default:
                    System.out.println("Wrong input, try again!");
                    unavailableItem();
            }
        }
    }
}
