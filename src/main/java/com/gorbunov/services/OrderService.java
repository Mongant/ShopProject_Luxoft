package com.gorbunov.services;

import com.gorbunov.domain.Client;
import com.gorbunov.domain.Order;
import com.gorbunov.domain.Product;

import java.util.List;

public interface OrderService {

    /**
     * Create new custom order for products
     * @param client sets the client information
     * @param products sets the producs list
     * */
    void createOrder(Client client, List<Product> products);

    /**
     * Method for delete order by id
     * @param id order unique identifier
     * */
    void deleteOrder(long id);

    /**
     * Сreates a report on order
     * @param client information about client
     * @param products information about products
     * */
    Order reportBuildingOrder(Client client, List<Product> products);

    /**
     * Get information about orders
     * */
    List<Order> listOrders();
}
