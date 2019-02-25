package com.gorbunov.services.impl;

import com.gorbunov.dao.OrderDao;
import com.gorbunov.dao.impl.OrderDaoImpl;
import com.gorbunov.domain.Client;
import com.gorbunov.domain.Order;
import com.gorbunov.domain.Product;
import com.gorbunov.services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = OrderDaoImpl.getInstance();

    @Override
    public void createOrder(Client client, List<Product> products) {
        Order order = new Order(client, products);
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

    @Override
    public Order showOrder(Client client, List<Product> products) {
        float amount = 0;
        Order order = new Order(client, products);
        for(Product product : products) {
            amount = product.getPrice() + amount;
        }
        order.setAmount(amount);
        orderDao.addOrders(order);
        orderDao.addOrders(order);
        return orderDao.showOrder();
    }

    @Override
    public List<Order> listOrders() {
        if(!orderDao.listOrders().isEmpty()) {
            return orderDao.listOrders();
        } else {
            System.out.println("Order list is empty!");
            return orderDao.listOrders();
        }
    }
}
