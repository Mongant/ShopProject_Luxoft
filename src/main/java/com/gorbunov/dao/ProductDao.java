package com.gorbunov.dao;

import com.gorbunov.domain.Product;

import java.util.List;

public interface ProductDao {

    /**
     * Add product to database
     * @param product information about product
     * */
    void addProduct(Product product);

    /**
     * Get product information by id in database
     * @param id product unique identifier
     * */
    Product getProduct(long id);
    List<Product> productList();
    List<Product> showProductContainer(String ref);
    void updateProduct(long id, Product product);
    void deleteProduct(long id);
}
