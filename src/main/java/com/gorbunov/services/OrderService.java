package com.gorbunov.services;

import com.gorbunov.domain.Client;
import com.gorbunov.domain.Product;

import java.util.List;

public interface OrderService {

    /**
     * Create new custom order for products
     * @param client sets the client information
     * @param products sets the producs list
     * @param amount sets the amount of the purchase
     * */
    void createOrder(Client client, List<Product> products, float amount);

    /**
     * Method for modify order by id
     * @param id order unique identifier
     * */
    void modifyOrder(long id);

    /**
     * Method for delete order by id
     * @param id order unique identifier
     * */
    void deleteOrder(long id);
}
