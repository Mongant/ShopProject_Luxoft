package com.gorbunov.dao;

import com.gorbunov.domain.Product;

import java.util.List;

public interface ProductContainerDao {
    void addProductContainer(long id, String ref);
    void updateProductConteiner(long id, String ref);
    void deleteProductConteiner(long id, String ref);
}
