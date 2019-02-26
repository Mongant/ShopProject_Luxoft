package com.gorbunov.dao.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {

    private Map<Long, Product> products = new HashMap<>();
    private List<Product> productContainer = new ArrayList<>();
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
        if(product.getId() == 0) {
            product.setId(generatorProductId++);
        }
        products.put(product.getId(), product);
    }

    @Override
    public Product getProduct(long id) {
        return products.get(id);
    }

    @Override
    public List<Product> showProductContainer() {
        return productContainer;
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

    @Override
    public void addProductContainer(long id) {
        productContainer.add(products.get(id));
    }

    @Override
    public void clearProductContainer() {
        productContainer.clear();
    }
}
