package com.gorbunov.dao.impl;

import com.gorbunov.dao.ProductContainerDao;
import com.gorbunov.dao.dbcp.DataBaseConnection;
import com.gorbunov.domain.Product;
import com.gorbunov.domain.ProductContainer;
import com.gorbunov.utils.ReaderIniFile;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ProductContainerDaoImpl implements ProductContainerDao {

    DataBaseConnection dbConnection = new DataBaseConnection();
    private static ProductContainerDao productContainerDao = null;

    private ProductContainerDaoImpl() {
    }

    public static ProductContainerDao getInstance() {
        if(productContainerDao == null) {
            productContainerDao = new ProductContainerDaoImpl();
        }
        return productContainerDao;
    }

    @Override
    public void addProductContainer(long id, String refId) {
        String sql = ReaderIniFile.iniReader("Product container operation", "ADD_PRODUCT_CONTAINER");

        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, refId);
            preparedStatement.setLong(2 , id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ProductContainer getProductContainerItem(long id, String refId) {
        long productContainerId;
        long productId;
        String productName;
        String description;
        float price;
        Map<Long, Product> products = new HashMap<>();

        String sql = ReaderIniFile.iniReader("Product container operation", "GET_PRODUCT_CONTAINER_ITEM");

        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, refId);
            preparedStatement.setLong(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productContainerId = resultSet.getLong(1);
                productId = resultSet.getLong(2);
                productName = resultSet.getString(3);
                description = resultSet.getString(4);
                price = resultSet.getFloat(5);

                products.put(productContainerId , new Product(productId, productName, description, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ProductContainer(refId, products);
    }

    @Override
    public void deleteProductContainerItem(long id, String refId) {
        String sql = ReaderIniFile.iniReader("Product container operation", "DELETE_PRODUCT_CONTAINER_ITEM");

        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, refId);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProductContainer showProductContainer(String refId) {
        long productContainerId;
        long productId;
        String productName;
        String description;
        float price;
        Map<Long, Product> products = new HashMap<>();

        String sql = ReaderIniFile.iniReader("Product container operation", "PRODUCT_CONTAINER_LIST");
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, refId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productContainerId = resultSet.getLong(1);
                productId = resultSet.getLong(2);
                productName = resultSet.getString(3);
                description = resultSet.getString(4);
                price = resultSet.getFloat(5);

                products.put(productContainerId , new Product(productId, productName, description, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ProductContainer(refId, products);
    }
}
