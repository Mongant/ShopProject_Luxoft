package com.gorbunov.dao;

import com.gorbunov.domain.Order;

import java.util.List;

public interface OrderDao {
    void addOrders(Order order);
    List<Order> listOrders();
    boolean modifyOrder(long id, Order order);
    boolean deleteOrder(long id);
}
