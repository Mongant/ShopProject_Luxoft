package com.gorbunov.dao.impl;

import com.gorbunov.dao.ProductContainerDao;
import com.gorbunov.dao.dbcp.DataBaseConnection;
import com.gorbunov.domain.Product;
import com.gorbunov.domain.ProductContainer;
import com.gorbunov.utils.HibernateSessionFactoryUtil;
import com.gorbunov.utils.ReaderIniFile;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductContainerDaoImpl implements ProductContainerDao {

    @Autowired
    ProductContainer productContainer;

    @Autowired
    Product product;

    DataBaseConnection dbConnection = new DataBaseConnection();

    private ProductContainerDaoImpl() {
    }

    @Override
    public void addProductContainer(long id, String refId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(productContainer);
        transaction.commit();
        session.close();
    }

    public ProductContainer getProductContainerItem(long id, String refId) {
        long productContainerId;
        long productId;
        String productName;
        String description;
        float price;
        List<Product> products = new ArrayList<>();

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

                products.add(new Product(productId, productName, description, price));
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
        List<Product> products = new ArrayList<>();

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

                products.add(new Product(productId, productName, description, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ProductContainer(refId, products);
    }
}
