package com.gorbunov.services.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.dao.impl.ProductDaoImpl;
import com.gorbunov.domain.Product;
import com.gorbunov.services.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    ProductDao productDao = ProductDaoImpl.getInstance();
    private Map<Long, List<Product>> productBasket = new HashMap<>();

    @Override
    public Product createProduct(String name, String description, float price) {
        Product product;
        product = new Product(name, description, price);
        productDao.addProduct(product);
        return product;
    }

    @Override
    public void modifyProduct(long id, Product product) {
        if(productDao.modifyProduct(id, product)) {
            System.out.println("Product by id: " + id + " was modify!");
        } else {
            System.err.println("Product by id: " + id + " was not found!");
        }
    }

    @Override
    public void deleteProduct(long id) {
        if(productDao.deleteProduct(id)) {
            System.out.println("Product by id: " + id + " was removed!");
        } else {
            System.err.println("Product by id: " + id + " was not found!");
        }
    }

    @Override
    public List<Product> productList() {
        return productDao.productList();
    }
}
