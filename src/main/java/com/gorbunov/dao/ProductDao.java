package com.gorbunov.dao;

import com.gorbunov.domain.Product;

import java.util.List;

public interface ProductDao {
    List<Product> listProducts(Product product);
    boolean modifyProduct(long id);
    boolean deleteProduct(long id);
}
