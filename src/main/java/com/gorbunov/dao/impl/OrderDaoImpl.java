package com.gorbunov.dao.impl;

import com.gorbunov.dao.OrderDao;
import com.gorbunov.dao.dbcp.DataBaseConnection;
import com.gorbunov.domain.Client;
import com.gorbunov.domain.Order;
import com.gorbunov.domain.Product;
import com.gorbunov.utils.ReaderIniFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    DataBaseConnection dbConnection = new DataBaseConnection();

    @Override
    public void addOrder(long id, String refId, float amount) {
        String sql = ReaderIniFile.iniReader("Order operation", "ADD_NEW_ORDER");

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, refId);
            preparedStatement.setFloat(3, amount);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> showAllOrders() {
        return null;
    }

    @Override
    public void deleteOrder(long id) {
        String sql = ReaderIniFile.iniReader("Order operation", "DELETE_ORDER");

        try(Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order showOrder(String refId) {
        return null;
    }
}