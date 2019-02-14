package com.gorbunov.services;

import com.gorbunov.domain.Client;
import com.gorbunov.domain.Product;

import java.util.List;

public interface OrderService {

    /**
     * Method to create new order
     * */
    void createOrder(Client client, List<Product> products, float amount);

    /**
     * Method for modify order by id
     * */
    void modyfyOrder(long id);

    /**
     * Method for delete order by id
     * */
    void deleteOrder(long id);
}
