package com.gorbunov.services.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.domain.Product;
import com.gorbunov.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product createProduct(String name, String description, float price) {
        Product product = new Product(name, description, price);
        productDao.addProduct(product);
        return product;
    }

    @Override
    public Product getProduct(long id) throws NullPointerException {
        return productDao.getProduct(id);
    }

    @Override
    public void updateProduct(long id, String name, String description, float price) {
        Product product = new Product(name, description, price);
        productDao.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(long id) {
        productDao.deleteProduct(id);
    }

    @Override
    public List<Product> productList() {
        if(!productDao.productList().isEmpty()){
            return productDao.productList();
        }
        System.err.println("Product list is empty!");
        return productDao.productList();
    }
}
