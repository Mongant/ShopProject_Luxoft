package com.gorbunov.dao.impl;

import com.gorbunov.dao.OrderDao;
import com.gorbunov.domain.Order;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public List<Order> orders(Order order) {
        return null;
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
