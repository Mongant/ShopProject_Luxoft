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
        long orderId = 0;
        String refId;
        float amount = 0;
        String clientName;
        String clientSurname;
        int clientAge;
        String clientPhone;
        String clientEmail;
        String productName;
        String productDescription;
        float price;
        List<Order> orders = new ArrayList<>();
        Order order;
        Client client = null;
        List<Product> products = new ArrayList<>();
        List<List<Product>> productsOrder = new ArrayList<>();
        String tempRefId = "";
        int countOrder = 0;

        String sql = ReaderIniFile.iniReader("Order operation", "SHOW_ALL_ORDERS");

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderId = resultSet.getLong(1);
                refId = resultSet.getString(2);
                amount = resultSet.getFloat(3);
                clientName = resultSet.getString(4);
                clientSurname = resultSet.getString(5);
                clientAge = resultSet.getInt(6);
                clientPhone = resultSet.getString(7);
                clientEmail = resultSet.getString(8);
                productName = resultSet.getString(9);
                productDescription = resultSet.getString(10);
                price = resultSet.getFloat(11);

                if ("".equals(tempRefId)) {
                    tempRefId = refId;
                }
                if (!tempRefId.equals(refId)) {
                    productsOrder.add(new ArrayList<>(products));
                    order = new Order(orderId, client, productsOrder.get(countOrder), amount);
                    countOrder++;
                    orders.add(order);
                    products.clear();
                }
                if (products.isEmpty()) {
                    client = new Client(clientName, clientSurname, clientPhone, clientAge, clientEmail);
                }
                products.add(new Product(productName, productDescription, price));
                tempRefId = refId;
            }
            productsOrder.add(new ArrayList<>(products));
            order = new Order(orderId, client, productsOrder.get(countOrder), amount);
            orders.add(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return orders;
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
        long clientId;
        String clientName;
        String clientSurname;
        int clientAge;
        String clientPhone;
        String clientEmail;
        long productId;
        String productName;
        String productDescription;
        float productPrice;
        float amount = 0;

        List<Product> products = new ArrayList<>();
        Client client = null;

        String sql = ReaderIniFile.iniReader("Order operation", "SHOW_ORDER");

        try(Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, refId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                clientId = resultSet.getLong(1);
                clientName = resultSet.getString(2);
                clientSurname = resultSet.getString(3);
                clientAge = resultSet.getInt(4);
                clientPhone = resultSet.getString(5);
                clientEmail = resultSet.getString(6);
                productId = resultSet.getLong(7);
                productName = resultSet.getString(8);
                productDescription = resultSet.getString(9);
                productPrice = resultSet.getFloat(10);
                amount = resultSet.getFloat(11);
                products.add(new Product(productId, productName, productDescription, productPrice));
                client = new Client(clientId, clientName, clientSurname, clientAge, clientPhone, clientEmail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Order(client, products, amount);
    }
}