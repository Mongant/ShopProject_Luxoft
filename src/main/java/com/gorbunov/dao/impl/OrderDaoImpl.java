package com.gorbunov.dao.impl;

import com.gorbunov.dao.OrderDao;
import com.gorbunov.domain.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {

    private Map<Long, Order> orders = new HashMap<>();
    private static long generatorId;
    private static OrderDao orderDao = new OrderDaoImpl();

    private OrderDaoImpl() {
    }

    public static OrderDao getInstance() {
        if(orderDao == null) {
            orderDao = new OrderDaoImpl();
        }
        return orderDao;
     }

    @Override
    public void addOrders(Order order) {
        generatorId++;
        orders.put(generatorId, order);
    }

    @Override
    public List<Order> listOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public boolean modifyOrder(long id, Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(long id) {
        return true;
    }

    @Override
    public Order showOrder() {
        long id = orders.size();
        return orders.get(id);
    }
}
