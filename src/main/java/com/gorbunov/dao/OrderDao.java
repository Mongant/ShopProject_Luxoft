package com.gorbunov.dao;

import com.gorbunov.domain.Order;

import java.util.List;

public interface OrderDao {
    void addOrder(long id, String refId, float amount);
    List<Order> showAllOrders();
    void deleteOrder(long id);
    Order showOrder(String refId);
}
