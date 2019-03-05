package com.gorbunov.dao.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.dao.dbcp.DataBaseConnection;
import com.gorbunov.domain.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private long productId;
    private String productName;
    private String description;
    private float price;
    private static ProductDao productDao;

    DataBaseConnection dbConnection = new DataBaseConnection();


    private ProductDaoImpl() {
    }

    public static ProductDao getInstance() {
        if(productDao == null) {
            productDao = new ProductDaoImpl();
        }
        return productDao;
    }

    @Override
    public void addProduct(Product product) {
        String sql = "insert into SHOP.PRODUCT(PRODUCT_NAME, DESCRIPTION, PRICE) " +
                "values ('" + product.getName() + "', '" + product.getDescription() + "', " + product.getPrice() + ");";
        dbConnection.sqlStatement(sql);
    }

    @Override
    public List<Product> productList() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from SHOP.PRODUCT;";
        try {
            ResultSet resultSet = dbConnection.getResultSet(sql);
            while(resultSet.next()) {
                productId = resultSet.getLong(1);
                productName = resultSet.getString(2);
                description = resultSet.getString(3);
                price = resultSet.getFloat(4);
                Product product = new Product(productId, productName, description, price);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProduct(long id) {
        Product product = null;
        try {
            String sql = "select ID, PRODUCT_NAME, DESCRIPTION, PRICE\n" +
                    "from SHOP.PRODUCT\n" +
                    "where ID = " + id + ";";
            ResultSet resultSet = dbConnection.getResultSet(sql);
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
    public List<Product> showProductContainer(String ref) {
        List<Product> products = new ArrayList<>();
        String sql = "select t2.PRODUCT_ID, t1.PRODUCT_NAME, t1.DESCRIPTION, t1.PRICE\n" +
                    "from SHOP.PRODUCT as t1\n" +
                    "join SHOP.PRODUCT_CONTAINER as t2 on t1.ID = t2.PRODUCT_ID\n" +
                    "where t2.REF_ID = '" + ref + "'";
        try {
            ResultSet resultSet = dbConnection.getResultSet(sql);
            while (resultSet.next()) {
                productId = resultSet.getInt(1);
                productName = resultSet.getString(2);
                description = resultSet.getString(3);
                price = resultSet.getFloat(4);
                products.add(new Product(productId, productName, description, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void updateProduct(long id, Product product) {
        String sql = "update SHOP.PRODUCT" +
                "\nset PRODUCT_NAME = '" + product.getName() + "', DESCRIPTION = '" + product.getDescription() + "', PRICE = " + product.getPrice() +
                " \nwhere ID = " + id + ";";
        dbConnection.sqlUpdate(sql);
    }

    @Override
    public void deleteProduct(long id) {
        String sql = "delete from SHOP.PRODUCT where ID = " + id + ";";
        dbConnection.sqlStatement(sql);
    }
}
