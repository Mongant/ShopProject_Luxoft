package com.gorbunov.view;

import com.gorbunov.services.ClientService;
import com.gorbunov.services.OrderService;
import com.gorbunov.services.ProductService;
import com.gorbunov.validator.BusinessException;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientMenu {

    private BufferedReader br;
    private ClientService clientService;
    private ProductService productService;
    private OrderService orderService;

    public ClientMenu(BufferedReader br, ClientService clientService, ProductService productService, OrderService orderService) {
        this.br = br;
        this.clientService = clientService;
        this.productService = productService;
        this.orderService = orderService;
    }

    public void clientMenu() throws IOException, BusinessException {
        boolean isRunning = true;
        clientOptions();

        while (isRunning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    System.out.println("Create client");
                    createClient();
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
                    new MainMenu(br, clientService, productService, orderService).showMenu();
                    break;
                default:
                    System.out.println("Wrong input, try again!");
                    clientMenu();
            }
        }
    }

    private void clientOptions() {
        System.out.println("\n1. Create client");
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

    private void createClient() {
        try {
            System.out.print("\nInput name: ");
            String name = br.readLine();
            System.out.print("Input surname: ");
            String surname = br.readLine();
            System.out.print("Input phone: ");
            String phone = br.readLine();
            System.out.print("Input age: ");
            int age = Integer.parseInt(br.readLine());
            System.out.print("Input email: ");
            String email = br.readLine();
            clientService.createClient(name, surname, phone, age, email);
            System.out.println("Client was created successfully!");
            clientMenu();
        } catch (BusinessException e) {
            System.err.println("The age is incorrect!");
            createClient();
        } catch (NumberFormatException e) {
            System.err.println("Incorrect input format age data!");
            createClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
