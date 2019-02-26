package com.gorbunov.view.admin;

import com.gorbunov.domain.Client;
import com.gorbunov.domain.Order;
import com.gorbunov.domain.Product;
import com.gorbunov.services.ClientService;
import com.gorbunov.services.OrderService;
import com.gorbunov.services.ProductService;
import com.gorbunov.validator.BusinessException;
import com.gorbunov.view.MainMenu;

import java.io.BufferedReader;
import java.io.IOException;

public class AdminMenu {

    private BufferedReader br;
    private ClientService clientService;
    private ProductService productService;
    private OrderService orderService;

    public AdminMenu(BufferedReader br, ClientService clientService, ProductService productService, OrderService orderService) {
        this.br = br;
        this.clientService = clientService;
        this.productService = productService;
        this.orderService = orderService;
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
                    new MainMenu(br, clientService, productService, orderService).showMenu();
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
                    System.out.println("Create client");
                    createClient();
                    break;
                case "2":
                    System.out.println("Modify client");
                    modifyClient();
                    clientAdminOptions();
                    break;
                case "3":
                    System.out.println("Remove client");
                    deleteClient();
                    clientAdminOptions();
                    break;
                case "4":
                    System.out.println("Show clients list");
                    showClientsList();
                    break;
                case "0":
                    adminMenu();
                    break;
                default:
                    System.err.println("Wrong input, try again!");
                    clientAdminOptions();
            }
        }
    }

    private void productAdminOptions() throws IOException, BusinessException {
        boolean isRunning = true;

        System.out.println("\n1. Add product");
        System.out.println("2. Modify product");
        System.out.println("3. Delete product");
        System.out.println("4. Product list");
        System.out.println("0. Return in admin menu");

        while (isRunning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    System.out.println("Add product");
                    createProduct();
                    break;
                case "2":
                    System.out.println("Modify product");
                    modifyProduct();
                    productAdminOptions();
                    break;
                case "3":
                    System.out.println("Delete product");
                    deleteProduct();
                    productAdminOptions();
                    break;
                case "4":
                    System.out.println("Product list");
                    showProductList();
                    break;
                case "0":
                    System.out.println("Return in admin menu");
                    adminMenu();
                    break;
                default:
                    System.err.println("Wrong input, try again!");
                    productAdminOptions();
            }
        }
    }

    private void orderAdminOptions() throws IOException, BusinessException {
        boolean isRunning = true;

        System.out.println("\n1. Create order");
        System.out.println("2. Delete order");
        System.out.println("3. Show all orders");
        System.out.println("0. Return in admin menu");

        while (isRunning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    System.out.println("Create order");
                    orderMenu();
                    break;
                case "2":
                    System.out.println("Delete order");
                    deleteOrder();
                    orderAdminOptions();
                    break;
                case "3":
                    System.out.println("Show all orders");
                    showOrderList();
                    orderAdminOptions();
                    break;
                case "0":
                    adminMenu();
                    break;
                default:
                    System.err.println("Wrong input, try again!");
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
            System.out.print("Input age: ");
            int age = Integer.parseInt(br.readLine());
            System.out.print("Input email: ");
            String email = br.readLine();
            clientService.createClient(name, surname, phone, age, email);
            clientAdminOptions();
        } catch (BusinessException e) {
            System.err.println(e.getMessage());
            createClient();
        } catch (NumberFormatException e) {
            System.err.println("Incorrect input format age data!");
            createClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void modifyClient() throws IOException {
        System.out.print("Enter client id: ");
        long id = Long.parseLong(br.readLine());
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
            clientService.modifyClient(id, name, surname, phone, age, email);
            System.out.println("Client was created successfully!");
            clientAdminOptions();
        } catch (BusinessException e) {
            System.err.println(e.getMessage());
            createClient();
        } catch (NumberFormatException e) {
            System.err.print("Incorrect input format age data!");
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
            sb.append("\nId: ").append(client.getId()).
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
        try {
            System.out.print("\nInput product name: ");
            String productName = br.readLine();
            System.out.print("Input product description: ");
            String description = br.readLine();
            System.out.print("Input price: ");
            float price = Float.parseFloat(br.readLine());
            productService.createProduct(productName, description, price);
        } catch (NumberFormatException e) {
            System.err.println("Incorrect data entered!");
            createProduct();
        }

        System.out.println("Product was created successfully!");
        productAdminOptions();
    }

    private void deleteProduct() throws IOException {
        System.out.print("Enter product id: ");
        long id = Long.parseLong(br.readLine());
        productService.deleteProduct(id);
    }

    private void showProductList() throws IOException, BusinessException {
        StringBuilder sb = new StringBuilder();
        for(Product product : productService.productList()) {
            sb.append("\nId: ").append(product.getId())
                    .append("; Product name: ").append(product.getName())
                    .append("; Description: ").append(product.getDescription())
                    .append("; Price: ").append(product.getPrice());
        }
        System.out.println(sb.toString());
        productAdminOptions();
    }

    private void modifyProduct() throws IOException {
        try {
            System.out.print("Enter product id: ");
            long id = Long.parseLong(br.readLine());
            System.out.print("\nInput product name: ");
            String productName = br.readLine();
            System.out.print("Input product description: ");
            String description = br.readLine();
            System.out.print("Input price: ");
            float price = Float.parseFloat(br.readLine());
            productService.modifyProduct(id, productName, description, price);
        } catch (NumberFormatException e) {
            System.err.println("Incorrect data entered!");
        }
    }

    private void orderMenu() throws IOException, BusinessException {

        boolean isRunning = true;

        System.out.println("\n1. Add products in order");
        System.out.println("2. Create order");
        System.out.println("0. Return in admin menu");

        while (isRunning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    System.out.println("Add products in order");
                    addProductInOrder();
                    break;
                case "2":
                    System.out.println("Create order");
                    createOrder();
                    orderAdminOptions();
                    break;
                case "0":
                    adminMenu();
                    break;
                default:
                    System.err.println("Wrong input, try again!");
                    orderAdminOptions();
            }
        }

        System.out.print("Input client id: ");
        long id = Long.parseLong(br.readLine());
        addProductInOrder();
        orderService.createOrder(clientService.getClient(id), productService.productList());
        System.out.println("Product was created successfully!");
        orderAdminOptions();
    }

    private void addProductInOrder() throws IOException, BusinessException {
        System.out.print("Enter product id: ");
        long id = Long.parseLong(br.readLine());
        productService.addProductBasket(id);
        orderMenu();
    }

    private void createOrder() throws IOException, BusinessException {
        try {
            StringBuilder sb = new StringBuilder();
            System.out.print("Input client id: ");
            long id = Long.parseLong(br.readLine());
            Order order = orderService.showOrder(clientService.getClient(id), productService.showProductBasket());
            orderService.createOrder(clientService.getClient(id), productService.productList());
            sb.append("\n---------------------------------------------------\n");
            sb.append("Client name: ").append(order.getClient().getName());
            sb.append("\nClient surname: ").append(order.getClient().getSurname());
            sb.append("\nProducts: \n");
            for(Product product : order.getProducts()) {
                sb.append(product.toString()).append("\n");
            }
            sb.append("\nAmount: ").append(order.getAmount());
            sb.append("\nThank you for your purchase!");
            sb.append("\n---------------------------------------------------\n");
            System.out.println(sb.toString());
            orderAdminOptions();
        } catch (NullPointerException e) {
            orderMenu();
        } catch (NumberFormatException e) {
            System.err.println("Incorrect data entered!");
        }

    }

    private void showOrderList() {
        StringBuilder sb = new StringBuilder();
        for(Order order : orderService.listOrders()) {
            sb.append("\nOrder id: ").append(order.getId())
                    .append(order.getClient())
                    .append(order.getProducts());
        }
        System.out.println(sb.toString());
    }

    private void deleteOrder() throws IOException {
        System.out.print("Enter product id: ");
        long id = Long.parseLong(br.readLine());
        orderService.deleteOrder(id);
    }
}
