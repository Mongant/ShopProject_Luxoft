package com.gorbunov.services.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.dao.impl.ProductDaoImpl;
import com.gorbunov.domain.Product;
import com.gorbunov.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductDao productDao = ProductDaoImpl.getInstance();

    @Override
    public Product createProduct(String name, String description, float price) {
        Product product = null;
        product = new Product(name, description, price);
        productDao.addProduct(product);
        return product;
    }

    @Override
    public void modifyProduct(long id, Product product) {
        if(productDao.modifyProduct(id, product)) {
            System.out.println("Add some changes in product id: " + id);
        } else {
            System.out.println("Something was wrong with modify product by id: " + id);
        }
    }

    @Override
    public void deleteProduct(long id) {
        if(productDao.deleteProduct(id)) {
            System.out.println("Order by id: " + id + " was removed!");
        } else {
            System.out.println("Something was wrong with delete product by id: " + id);
        }
    }

    @Override
    public List<Product> productList() {
        return productDao.productList();
    }
}
