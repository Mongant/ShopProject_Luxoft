package com.gorbunov.services.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.dao.impl.ProductDaoImpl;
import com.gorbunov.domain.Product;
import com.gorbunov.services.ProductService;

import java.math.BigDecimal;

public class ProductServiceImpl implements ProductService {

    ProductDao productDao = new ProductDaoImpl();

    @Override
    public void createProduct(String name, String description, float price) {
        Product product = new Product(name, description, price);
        productDao.listProducts(product);
    }

    @Override
    public void modyfyProduct(long id) {
        if(productDao.modifyProduct(id)) {
            System.out.println("Add some changes in product id: " + id);
        } else {
            System.out.println("Something was wrong!");
        }
    }

    @Override
    public void deleteProduct(long id) {
        if(productDao.modifyProduct(id)) {
            System.out.println("Order on id: " + id + " was removed!");
        } else {
            System.out.println("Something was wrong!");
        }
    }
}
