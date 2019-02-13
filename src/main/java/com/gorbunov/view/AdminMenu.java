package com.gorbunov.view;

import com.gorbunov.services.ClientService;
import com.gorbunov.services.ProductService;
import com.gorbunov.services.impl.ClietServiceImpl;
import com.gorbunov.services.impl.ProductServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class AdminMenu {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private final ClientService clientService = new ClietServiceImpl();
    private final ProductService productService = new ProductServiceImpl();

    public void adminMenu() throws IOException {
        boolean isRaning = true;
        adminOptions();

        while (isRaning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    System.out.println("Client options");
                    clientAdminOptions();
                    break;
                case "2":
                    System.out.println("Product options");
                    productAdminOptions();
                    break;
                case "3":
                    System.out.println("Order options");
                    orderAdminOptions();
                    break;
                case "0":
                    new MainMenu().showMenu();
                    break;
                default:
                    System.out.println("Wrong input, try again!");
                    adminMenu();
            }
        }
    }

    private void adminOptions() {
        System.out.println("\n1. Client options");
        System.out.println("2. Product options");
        System.out.println("3. Order options");
        System.out.println("0. Return in main menu");
    }

    private void clientAdminOptions() throws IOException {
        boolean isRaning = true;

        System.out.println("\n1. Create client");
        System.out.println("2. Modify client");
        System.out.println("3. Remove client");
        System.out.println("0. Return in admin menu");

        while (isRaning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    createClient();
                    break;
                case "2":
                    productAdminOptions();
                    break;
                case "3":
                    orderAdminOptions();
                    break;
                case "0":
                    new MainMenu().showMenu();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    private void productAdminOptions() throws IOException {
        boolean isRaning = true;

        System.out.println("\n1. Add product");
        System.out.println("2. Modify product");
        System.out.println("3. Delete product");
        System.out.println("0. Return in admin menu");

        while (isRaning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    createProduct();
                    break;
                case "2":
                    productAdminOptions();
                    break;
                case "3":
                    orderAdminOptions();
                    break;
                case "0":
                    new MainMenu().showMenu();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    private void orderAdminOptions() {
        System.out.println("\n1. Modify content");
        System.out.println("2. Delete order");
        System.out.println("0. Return in admin menu");
    }

    private void createClient() throws IOException {
        System.out.print("Input name: ");
        String name = br.readLine();
        System.out.print("Input surname: ");
        String surname = br.readLine();
        System.out.print("Input phone: ");
        String phone = br.readLine();

        clientService.createClient(name, surname, phone);
        System.out.println("Client was created successfully!");
        adminOptions();
    }

    private void createProduct() throws IOException {
        System.out.print("Input product name: ");
        String productName = br.readLine();
        System.out.print("Input product description: ");
        String description = br.readLine();
        System.out.print("Input price: ");
        float price = br.read();

        productService.createProduct(productName, description, price);
        System.out.println("Product was created successfully!");
        adminOptions();
    }


}
