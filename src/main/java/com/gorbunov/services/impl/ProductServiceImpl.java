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
        Product product = new Product(name, description, price);
        productDao.addProduct(product);
        return product;
    }

    @Override
    public Product getProduct(long id) {
        return productDao.getProduct(id);
    }

    @Override
    public void modifyProduct(long id, String name, String description, float price) {
        Product product = new Product(name, description, price);
        product.setId(id);
        if(productDao.modifyProduct(id, product)) {
            System.out.println("Client id: " + id + " was modify successfully!");
        } else {
            System.err.println("Client by id: " + id + " was not found!");
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
        if(!productDao.productList().isEmpty()){
            return productDao.productList();
        }
        System.out.println("Product list is empty!");
        return productDao.productList();
    }

    @Override
    public void addProductContainer(long id) {
        productDao.addProductContainer(id);
    }

    @Override
    public List<Product> showProductContainer() {
        return productDao.showProductContainer();
    }

    @Override
    public void clearProductContainer() {
        productDao.clearProductContainer();
    }
}
