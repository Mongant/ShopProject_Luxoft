package com.gorbunov.dao.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    static List<Product> products = new ArrayList<>();

    @Override
    public List<Product> listProducts(Product product) {

        products.add(product);
        return products;
    }

    @Override
    public boolean modifyProduct(long id) {
        return true;
    }

    @Override
    public boolean deleteProduct(long id) {
        return true;
    }
}
