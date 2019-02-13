package com.gorbunov.services;

import com.gorbunov.domain.Client;
import com.gorbunov.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void createProduct(String name, String description, float price);
    void modyfyProduct(long id);
    void deleteProduct(long id);
}
