package com.gorbunov.view;

import com.gorbunov.domain.Product;
import com.gorbunov.services.ClientService;
import com.gorbunov.services.OrderService;
import com.gorbunov.services.ProductService;
import com.gorbunov.services.impl.ClietServiceImpl;
import com.gorbunov.services.impl.OrderServiceImpl;
import com.gorbunov.services.impl.ProductServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class AdminMenu {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private final ClientService clientService = new ClietServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

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
                    clientService.modifyClient(120156);
                    clientAdminOptions();
                    break;
                case "3":
                    clientService.deleteClient(120156);
                    clientAdminOptions();
                    break;
                case "0":
                    adminMenu();
                    break;
                default:
                    System.out.println("Wrong input, try again!");
                    clientAdminOptions();
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
                    productService.modyfyProduct(120156);
                    productAdminOptions();
                    break;
                case "3":
                    productService.deleteProduct(120156);
                    productAdminOptions();
                    break;
                case "0":
                    adminMenu();
                    break;
                default:
                    System.out.println("Wrong input, try again!");
                    productAdminOptions();
            }
        }
    }

    private void orderAdminOptions() throws IOException {
        boolean isRaning = true;

        System.out.println("\n1. Create order");
        System.out.println("2. Modify content");
        System.out.println("3. Delete order");
        System.out.println("0. Return in admin menu");

        while (isRaning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    createOrder();
                    break;
                case "2":
                    orderService.modyfyOrder(120156);
                    orderAdminOptions();
                    break;
                case "3":
                    orderService.deleteOrder(120156);
                    orderAdminOptions();
                    break;
                case "0":
                    adminMenu();
                    break;
                default:
                    System.out.println("Wrong input, try again!");
                    orderAdminOptions();
            }
        }
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
        clientAdminOptions();
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
        productAdminOptions();
    }

    private void createOrder() throws IOException {
        System.out.print("Input client id: ");
        String client = br.readLine();
        System.out.print("Input products id: ");
        String products = br.readLine();
        System.out.print("Input amount: ");
        float amount = br.read();

//        orderService.createOrder(client, products, amount);
        System.out.println("Product was created successfully!");
        orderAdminOptions();
    }
}
