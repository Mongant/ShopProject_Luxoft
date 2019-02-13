package com.gorbunov.dao;

import com.gorbunov.domain.Order;

import java.util.List;

public interface OrderDao {
    List<Order> orders(Order order);
    boolean modifyOrder(long id);
    boolean deleteOrder(long id);
}
