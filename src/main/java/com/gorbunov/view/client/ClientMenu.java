package com.gorbunov.view.client;

import com.gorbunov.domain.Order;
import com.gorbunov.domain.Product;
import com.gorbunov.services.ClientService;
import com.gorbunov.services.OrderService;
import com.gorbunov.services.ProductContainerService;
import com.gorbunov.services.ProductService;
import com.gorbunov.utils.GenerateId;
import com.gorbunov.validator.BusinessException;
import com.gorbunov.view.MainMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ClientMenu {

    private String refId;
    private BufferedReader br;
    private ClientService clientService;
    private ProductService productService;
    private ProductContainerService productContainerService;
    private OrderService orderService;

    public ClientMenu(BufferedReader br,
                      ClientService clientService,
                      ProductService productService,
                      ProductContainerService productContainerService,
                      OrderService orderService) {
        this.br = br;
        this.clientService = clientService;
        this.productService = productService;
        this.productContainerService = productContainerService;
        this.orderService = orderService;
        this.refId = GenerateId.generateId();
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
                    new MainMenu(br, clientService, productService, productContainerService, orderService).showMenu();
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

        System.out.println("\n1. Show all products");
        System.out.println("2. Add product on basket");
        System.out.println("3. Remove product on basket");
        System.out.println("4. Show products on basket");
        System.out.println("5. Buy (Show order)");
        System.out.println("0. Return in client menu");

        while (isRunning) {
            System.out.print("\nSelect your choice => ");
            String input = br.readLine();
            switch (input) {
                case "1":
                    System.out.println("Show all products");
                    showProductList();
                    break;
                case "2":
                    System.out.println("Add product on basket");
                    addProductContainer();
                    break;
                case "3":
                    System.out.println("Remove product on basket");
                    deleteProductContainer();
                    break;
                case "4":
                    System.out.println("Show products on basket");
                    showProductContainer();
                    break;
                case "5":
                    System.out.println("Buy (Show order)");
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

    private void addProductContainer() throws IOException, BusinessException {
        System.out.print("Enter product id: ");
        long id = Long.parseLong(br.readLine());
        Product product = productService.getProduct(id);
        if(product != null) {
            productContainerService.addProductContainer(id, refId);
        } else {
            System.err.println("Product ID: " + id + " does not exist");
        }
        shoppingBasket();
    }

    private void deleteProductContainer() throws IOException, BusinessException {
        System.out.print("Enter product id: ");
        long id = Long.parseLong(br.readLine());
        if(productContainerService.getProductContainerItem(id, refId) != null) {
            productContainerService.deleteProductContainer(id, refId);
        } else {
            System.err.println("Product ID: " + id + " does not exist");
        }
        shoppingBasket();
    }

    private void showProductContainer() {
        StringBuilder sb = new StringBuilder();
        Iterator it = productContainerService.showProductContainer(refId).getProductsContainer().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            sb.append("\nID: ").append(pair.getKey()).append(" ").append(pair.getValue());
        }
        System.out.println(sb.toString());
    }

    private void showOrder() throws IOException, BusinessException {
        orderService.addOrder(clientService.listClients().get(clientService.listClients().size() -1).getId(), refId, new ArrayList<Product>(productContainerService.showProductContainer(refId).getProductsContainer().values()));
        Order order = orderService.showOrder(refId);
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
        refId = GenerateId.generateId();
        shoppingBasket();
    }
}
