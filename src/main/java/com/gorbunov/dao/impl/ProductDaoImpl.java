package com.gorbunov.dao.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.dao.dbcp.DataBaseConnection;
import com.gorbunov.domain.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {

    private long productId;
    private String productName;
    private String description;
    private float price;

    DataBaseConnection dbConnection = new DataBaseConnection();

    private Map<Long, Product> products = new HashMap<>();
    private List<Product> productBasket = new ArrayList<>();
    private static long generatorProductId = 1;
    private static ProductDao productDao = new ProductDaoImpl();

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
        dbConnection.closeDataBaseConnection();
    }

    @Override
    public List<Product> productList() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "select * from SHOP.PRODUCT;";
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
        return products.get(id);
    }


    @Override
    public void addProductBasket(Product product) {
        productBasket.add(product);
    }

    @Override
    public List<Product> showProductBasket() {
        return productBasket;
    }

    @Override
    public boolean modifyProduct(long id, Product product) {
        Product value = products.get(id);
        if(value != null) {
            products.put(id, product);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteProduct(long id) {
        Product value = products.get(id);
        if(value != null) {
            products.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addProductBasket(long id) {
        productBasket.add(products.get(id));
    }
}
