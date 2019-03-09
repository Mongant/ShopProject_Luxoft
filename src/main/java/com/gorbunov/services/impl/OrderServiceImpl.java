package com.gorbunov.services.impl;

import com.gorbunov.dao.OrderDao;
import com.gorbunov.dao.impl.OrderDaoImpl;
import com.gorbunov.domain.Order;
import com.gorbunov.domain.Product;
import com.gorbunov.services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = OrderDaoImpl.getInstance();

    @Override
    public void addOrder(long clientId, String refId, List<Product> products) {
        float amount = 0;
        for(Product product : products) {
            amount = product.getPrice() + amount;
        }
        orderDao.addOrder(clientId, refId, amount);
    }

    @Override
    public void deleteOrder(long id) {
        orderDao.deleteOrder(id);
    }

    @Override
    public Order showOrder(String refId) {
        return orderDao.showOrder(refId);
    }

    @Override
    public List<Order> listOrders() {
        if(!orderDao.showAllOrders().isEmpty()) {
            return orderDao.showAllOrders();
        } else {
            System.err.println("Order list is empty!");
            return orderDao.showAllOrders();
        }
    }
}
