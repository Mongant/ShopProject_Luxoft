package com.gorbunov.dao;

import com.gorbunov.domain.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    List<Product> listProducts();
    boolean modifyProduct(long id);
    boolean deleteProduct(long id);
}
