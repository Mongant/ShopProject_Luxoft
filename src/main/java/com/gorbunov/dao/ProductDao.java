package com.gorbunov.dao;

import com.gorbunov.domain.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    Product getProduct(long id);
    List<Product> productList();
    List<Product> showProductContainer(String ref);
    void updateProduct(long id, Product product);
    void deleteProduct(long id);
}
