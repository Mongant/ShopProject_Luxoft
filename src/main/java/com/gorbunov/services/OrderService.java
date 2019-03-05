package com.gorbunov.services;

import com.gorbunov.domain.Client;
import com.gorbunov.domain.Order;
import com.gorbunov.domain.Product;

import java.util.List;

public interface OrderService {

    /**
     * Create new custom order for products
     * @param clientId client unique identifier
     * @param products sets the producs list
     * */
    void addOrder(long clientId, String refId, List<Product> products);

    /**
     * Method for delete order by id
     * @param id order unique identifier
     * */
    void deleteOrder(long id);

    Order showOrder(String refId);

    /**
     * Get information about orders
     * */
    List<Order> listOrders();
}
