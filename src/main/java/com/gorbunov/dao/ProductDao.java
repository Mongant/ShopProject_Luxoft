package com.gorbunov.dao;

import com.gorbunov.domain.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    void appProductBasket(Product product);
    List<Product> productList();
    List<Product> showProductBasket();
    boolean modifyProduct(long id, Product product);
    boolean deleteProduct(long id);
    void addProductBasket(long id);
}
