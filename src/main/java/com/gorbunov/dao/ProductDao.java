package com.gorbunov.dao;

import com.gorbunov.domain.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    List<Product> productList();
    boolean modifyProduct(long id, Product product);
    boolean deleteProduct(long id);
}
