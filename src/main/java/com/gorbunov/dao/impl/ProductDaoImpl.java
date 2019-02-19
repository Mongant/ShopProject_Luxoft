package com.gorbunov.dao.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {

    private Map<Long, Product> products = new HashMap<>();
    private static long generatorId = 1;
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
        if(product.getId() == 0) {
            product.setId(generatorId++);
        }
        products.put(product.getId(), product);
    }

    @Override
    public List<Product> productList() {
        return new ArrayList<>(products.values());
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
}
