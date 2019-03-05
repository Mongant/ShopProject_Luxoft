package com.gorbunov.dao.impl;

import com.gorbunov.dao.OrderDao;
import com.gorbunov.dao.dbcp.DataBaseConnection;
import com.gorbunov.domain.Client;
import com.gorbunov.domain.Order;
import com.gorbunov.domain.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {

    private long clientId;
    private String clientName;
    private String clientSurname;
    private int clientAge;
    private String clientPhone;
    private String clientEmail;
    private long productId;
    private String productName;
    private String productDescription;
    private float productPrice;

    private Map<Long, Order> orders = new HashMap<>();
    private static OrderDao orderDao = new OrderDaoImpl();
    DataBaseConnection dbConnection = new DataBaseConnection();

    private OrderDaoImpl() {
    }

    public static OrderDao getInstance() {
        if(orderDao == null) {
            orderDao = new OrderDaoImpl();
        }
        return orderDao;
    }

    @Override
    public void addOrder(long id, String refId, float amount) {
        String sql = "insert into SHOP.\"ORDER\" (CLIENT_ID, REF_PRODUCT_CONTEINER, AMOUNT) VALUES (" + id + ", '" + refId + "', " + amount + ");";
        dbConnection.sqlStatement(sql);
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
        Order value = orders.get(id);
        if(value != null) {
            orders.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Order showOrder(String refId) {
        List<Product> products = new ArrayList<>();
        Client client = null;

        String sql = "select t2.ID, t2.NAME, t2.SURNAME, t2.AGE, t2.PHONE_NUM, t2.EMAIL, t4.ID, t4.PRODUCT_NAME, t4.DESCRIPTION, t4.PRICE\n" +
                     "from SHOP.\"ORDER\" as t1\n" +
                     "join SHOP.CLIENT as t2 on t1.CLIENT_ID = t2.ID\n" +
                     "join SHOP.PRODUCT_CONTAINER as t3 on t1.REF_PRODUCT_CONTEINER = t3.REF_ID\n" +
                     "join SHOP.PRODUCT as t4 on t3.PRODUCT_ID = t4.ID\n" +
                     "where t3.REF_ID = '" + refId + "';";
        try {
            ResultSet resultSet = dbConnection.getResultSet(sql);
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
                products.add(new Product(productId, productName, productDescription, productPrice));
                client = new Client(clientId, clientName, clientSurname, clientAge, clientPhone, clientEmail);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Order(client, products);
    }
}
