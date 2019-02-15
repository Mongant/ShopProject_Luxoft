package com.gorbunov.dao.impl;

import com.gorbunov.dao.OrderDao;
import com.gorbunov.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    static List<Order> orders = new ArrayList<>();

    @Override
    public void addOrders(Order order) {
        orders.add(order);
    }

    @Override
    public List<Order> listOrders() {
        return orders;
    }

    @Override
    public boolean modifyOrder(long id) {
        return true;
    }

    @Override
    public boolean deleteOrder(long id) {
        return true;
    }
}
