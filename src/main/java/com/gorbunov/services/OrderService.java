package com.gorbunov.services;

import com.gorbunov.domain.Client;
import com.gorbunov.domain.Product;

import java.util.List;

public interface OrderService {
    void createOrder(Client client, List<Product> products, float amount);
    void modyfyOrder(long id);
    void deleteOrder(long id);
}
