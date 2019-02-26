package com.gorbunov.view.client;

import com.gorbunov.domain.Order;
import com.gorbunov.domain.Product;
import com.gorbunov.services.ClientService;
import com.gorbunov.services.OrderService;
import com.gorbunov.services.ProductService;
import com.gorbunov.validator.BusinessException;
import com.gorbunov.view.MainMenu;

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
                    System.out.println("Shopping");
                    shoppingBasket();
                    break;
                case "0":
                    System.out.println("Main menu");
                    new MainMenu(br, clientService, productService, orderService).showMenu();
                    break;
                default:
                    System.err.println("Wrong input, try again!");
                    clientMenu();
            }
        }
    }

    private void clientOptions() {
        System.out.println("\n1. Create client");
        System.out.println("2. Shopping");
        System.out.println("3. Order");
        System.out.println("4. Modify information" );
        System.out.println("5. Delete client");
        System.out.println("0. Return in main menu");
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

    private void shoppingBasket() throws IOException, BusinessException {
        boolean isRunning = true;

        System.out.println("\n1. Show products");
        System.out.println("2. Add product on basket");
        System.out.println("3. Remove product on basket");
        System.out.println("4. Show all my purchases");
        System.out.println("5. Buy");
        System.out.println("0. Return in client menu");

        while (isRunning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    System.out.println("Show products");
                    showProductList();
                    break;
                case "2":
                    System.out.println("Add product on basket");
                    addProductBasket();
                    break;
                case "3":
                    System.out.println("Remove product on basket");
                    showOrder();
                    break;
                case "4":
                    System.out.println("Show all my purchases");
                    showPurchases();
                    break;
                case "5":
                    System.out.println("Buy");
                    showOrder();
                    break;
                case "0":
                    System.out.println("Return in client menu");
                    clientMenu();
                    break;
                default:
                    System.out.println("Wrong input, try again!");
                    shoppingBasket();
            }
        }
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
        shoppingBasket();
    }

    private void addProductBasket() throws IOException, BusinessException {
        System.out.print("Enter product id: ");
        long id = Long.parseLong(br.readLine());
        productService.addProductContainer(id);
        shoppingBasket();
    }

    private void showPurchases() throws IOException, BusinessException {
        StringBuilder sb = new StringBuilder();
        for(Product product : productService.showProductContainer()) {
            sb.append("\nId: ").append(product.getId())
                    .append("; Product name: ").append(product.getName())
                    .append("; Description: ").append(product.getDescription())
                    .append("; Price: ").append(product.getPrice());
        }
        System.out.println(sb.toString());
        shoppingBasket();
    }

    private void showOrder() throws IOException, BusinessException {
        Order order = orderService.reportBuildingOrder(clientService.listClients().get(clientService.listClients().size() - 1), productService.showProductContainer());
        StringBuilder sb = new StringBuilder();
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
        shoppingBasket();
    }
}
