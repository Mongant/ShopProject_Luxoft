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
     * Method for modify order by id
     * @param id order unique identifier
     * */
    void modifyOrder(long id, Order order);

    /**
     * Method for delete order by id
     * @param id order unique identifier
     * */
    void deleteOrder(long id);

    Order showOrder(Client client, List<Product> products);

    List<Order> listOrders();
}
