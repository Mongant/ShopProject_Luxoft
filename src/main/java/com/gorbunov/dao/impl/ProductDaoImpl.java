package com.gorbunov.dao.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> listProducts(Product product) {
        List<Product> products = new ArrayList<>();
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
