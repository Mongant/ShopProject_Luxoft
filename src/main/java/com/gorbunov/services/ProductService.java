package com.gorbunov.services;

import com.gorbunov.domain.Client;
import com.gorbunov.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    /**
     * Method to create new product
     * */
    void createProduct(String name, String description, float price);

    /**
     * Method for modify data product by id
     * */
    void modyfyProduct(long id);

    /**
     * Method for modify data product by id
     * */
    void deleteProduct(long id);
}
