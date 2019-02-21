package com.gorbunov.view;

import com.gorbunov.services.ClientService;
import com.gorbunov.services.OrderService;
import com.gorbunov.services.ProductService;
import com.gorbunov.validator.BusinessException;

import java.io.BufferedReader;
import java.io.IOException;

public class MainMenu {

    private BufferedReader br;
    private ClientService clientService;
    private ProductService productService;
    private OrderService orderService;

    public MainMenu(BufferedReader br, ClientService clientService, ProductService productService, OrderService orderService) {
        this.br = br;
        this.clientService = clientService;
        this.productService = productService;
        this.orderService = orderService;
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
                    new AdminMenu(br, clientService, productService, orderService).adminMenu();
                    break;
                case "2":
                    System.out.println("Client menu");
                    new ClientMenu(br, clientService, productService, orderService).clientMenu();
                    break;
                case "0":
                    System.out.println("Exit...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input");
                    showMenu();
            }
        }
    }
}
