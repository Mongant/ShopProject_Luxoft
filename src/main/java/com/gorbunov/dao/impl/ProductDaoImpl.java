package com.gorbunov.dao.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.dao.dbcp.DataBaseConnection;
import com.gorbunov.domain.Product;
import com.gorbunov.utils.ReaderIniFile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    DataBaseConnection dbConnection = new DataBaseConnection();

    @Override
    public void addProduct(Product product) {
        String sql = ReaderIniFile.iniReader("Product operation", "ADD_NEW_PRODUCT");

        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> productList() {
        long productId;
        String productName;
        String description;
        float price;

        List<Product> products = new ArrayList<>();
        String sql = ReaderIniFile.iniReader("Product operation", "PRODUCT_LIST");

        try(Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                productId = resultSet.getLong(1);
                productName = resultSet.getString(2);
                description = resultSet.getString(3);
                price = resultSet.getFloat(4);
                Product product = new Product(productId, productName, description, price);
                products.add(product);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProduct(long id) {
        long productId;
        String productName;
        String description;
        float price;

        Product product = null;
        String sql = ReaderIniFile.iniReader("Product operation", "GET_PRODUCT");

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    productId = resultSet.getInt(1);
                    productName = resultSet.getString(2);
                    description = resultSet.getString(3);
                    price = resultSet.getFloat(4);
                    product = new Product(productId, productName, description, price);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void updateProduct(long id, Product product) {
        String sql = ReaderIniFile.iniReader("Product operation","UPDATE_PRODUCT");

        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(long id) {
        String sql = ReaderIniFile.iniReader("Product operation","DELETE_PRODUCT");

        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
