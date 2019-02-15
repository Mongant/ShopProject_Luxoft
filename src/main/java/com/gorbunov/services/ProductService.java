package com.gorbunov.services;

public interface ProductService {

    /**
     * Method to create new product
     * @param name sets the product name
     * @param description sets the description for product
     * @param price sets the price for product
     * */
    void createProduct(String name, String description, float price);

    /**
     * Method for modify data product by id
     * @param id product unique identifier
     * */
    void modifyProduct(long id);

    /**
     * Method for modify data product by id
     * @param id product unique identifier
     * */
    void deleteProduct(long id);
}
