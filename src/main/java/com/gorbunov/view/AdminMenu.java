package com.gorbunov.view;

import com.gorbunov.domain.Client;
import com.gorbunov.services.ClientService;
import com.gorbunov.services.OrderService;
import com.gorbunov.services.ProductService;
import com.gorbunov.services.impl.OrderServiceImpl;
import com.gorbunov.services.impl.ProductServiceImpl;
import com.gorbunov.validator.BusinessException;
import com.gorbunov.validator.ValidationServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class AdminMenu {

    private BufferedReader br;

    private ClientService clientService;
    private final ProductService productService = new ProductServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    public AdminMenu(BufferedReader br, ClientService clientService) {
        this.br = br;
        this.clientService = clientService;
    }

    public void adminMenu() throws IOException, BusinessException {
        boolean isRunning = true;
        adminOptions();

        while (isRunning) {
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
                    new MainMenu(br, clientService).showMenu();
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

    private void clientAdminOptions() throws BusinessException, IOException {
        boolean isRunning = true;

        System.out.println("\n1. Create client");
        System.out.println("2. Modify client");
        System.out.println("3. Remove client");
        System.out.println("4. Show clients list");
        System.out.println("0. Return in admin menu");

        while (isRunning) {
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
                    deleteClient();
                    clientAdminOptions();
                    break;
                case "4":
                    showClientsList();
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

    private void productAdminOptions() throws IOException, BusinessException {
        boolean isRunning = true;

        System.out.println("\n1. Add product");
        System.out.println("2. Modify product");
        System.out.println("3. Delete product");
        System.out.println("0. Return in admin menu");

        while (isRunning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    createProduct();
                    break;
                case "2":
                    productService.modifyProduct(120156);
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

    private void orderAdminOptions() throws IOException, BusinessException {
        boolean isRunning = true;

        System.out.println("\n1. Create order");
        System.out.println("2. Modify content");
        System.out.println("3. Delete order");
        System.out.println("0. Return in admin menu");

        while (isRunning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    createOrder();
                    break;
                case "2":
                    orderService.modifyOrder(120156);
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

    private void createClient() {
        try {
            System.out.print("\nInput name: ");
            String name = br.readLine();
            System.out.print("Input surname: ");
            String surname = br.readLine();
            System.out.print("Input phone: ");
            String phone = br.readLine();
            if(!ValidationServiceImpl.validatePhoneNum(phone)) {
                System.err.println("Incorrect phone number format! Enter the data again.");
                createClient();
            }
            System.out.print("Input age: ");
            int age = Integer.parseInt(br.readLine());
            System.out.print("Input email: ");
            String email = br.readLine();
            if(!ValidationServiceImpl.validateEmail(email)) {
                System.out.println("Incorrect email! Enter the data again.");
                createClient();
            }
            clientService.createClient(name, surname, phone, age, email);
            System.out.println("Client was created successfully!");
            clientAdminOptions();
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

    private void deleteClient() throws IOException {
        System.out.print("Enter client id: ");
        long id = Long.parseLong(br.readLine());
        clientService.deleteClient(id);
    }

    private void showClientsList() throws IOException, BusinessException {
        StringBuilder sb = new StringBuilder();
        for(Client client:clientService.listClients()) {
            sb.append("ID: ").append(client.getId()).
            append(". Name: ").append(client.getName()).
            append("; Surname: ").append(client.getSurname()).
            append("; Phone: ").append(client.getPhone()).
            append("; Age: ").append(client.getAge()).
            append("; Email: ").append(client.getEmail());
        }
        System.out.println(sb.toString());
        clientAdminOptions();
    }

    private void createProduct() throws IOException, BusinessException {
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

    private void createOrder() throws IOException, BusinessException {
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
