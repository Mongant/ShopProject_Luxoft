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

    /**
     * Get information about products in database
     * */
    List<Product> productList();

    /**
     * Show information about products in product container
     * */
    List<Product> showProductContainer();

    /**
     * Modify data client by id in database
     * @param id customer unique identifier
     * @param product information about product
     * */
    boolean modifyProduct(long id, Product product);

    /**
     * Delete data product by id in database
     * @param id product unique identifier
     * */
    boolean deleteProduct(long id);

    /**
     * Group products into container
     * @param id product unique identifier
     * */
    void addProductContainer(long id);

    /**
     * Сlear all information about products into product container
     * */
    void clearProductContainer();
}
