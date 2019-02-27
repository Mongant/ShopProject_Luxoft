package com.gorbunov.services;

import com.gorbunov.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * Method to create new product
     * @param name sets the product name
     * @param description sets the description for product
     * @param price sets the price for product
     * */
    Product createProduct(String name, String description, float price);

    /**
     * Get product information by id
     * @param id product unique identifier
     * */
    Product getProduct(long id);

    /**
     * Modify data product by id
     * @param id product unique identifier
     * */
    void modifyProduct(long id, String name, String description, float price);

    /**
     * Delete product by id
     * @param id product unique identifier
     * */
    void deleteProduct(long id);

    /**
     * Get information about products
     * */
    List<Product> productList();

    /**
     * Group products into container
     * @param id product unique identifier
     * */
    void addProductContainer(long id);

    /**
     * Show information about products in product container
     * */
    List<Product> showProductContainer();

    /**
     * Сlear all information about products into product container
     * */
    void clearProductContainer();
}
