package com.gorbunov.services.impl;

import com.gorbunov.dao.OrderDao;
import com.gorbunov.dao.impl.OrderDaoImpl;
import com.gorbunov.domain.Client;
import com.gorbunov.domain.Order;
import com.gorbunov.domain.Product;
import com.gorbunov.services.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = OrderDaoImpl.getInstance();
    private Map<Long, Product> productsListOrder = new HashMap<>();

    @Override
    public void createOrder(Client client, List<Product> products, float amount) {
        Order order = new Order(client, products, amount);
        orderDao.addOrders(order);
    }

    public void modifyOrder(long id, Order order) {
        if(orderDao.modifyOrder(id, order)) {
            System.out.println("Add some changes in Order");
        } else {
            System.out.println("Something was wrong with modify order by id: " + id);
        }
    }

    @Override
    public void deleteOrder(long id) {
        if(orderDao.deleteOrder(id)) {
            System.out.println("Order on id: " + id + " was removed!");
        } else {
            System.out.println("Something was wrong with delete order by id: " + id);
        }
    }
}
