package com.gorbunov.services.impl;

import com.gorbunov.dao.ProductDao;
import com.gorbunov.dao.impl.ProductDaoImpl;
import com.gorbunov.domain.Product;
import com.gorbunov.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ProductServiceImplTest {

    ProductDao productDao = Mockito.mock(ProductDaoImpl.class);
    ProductService productService;

    @Before
    public void init(){
        productService = new ProductServiceImpl();
    }

    @Test
    public void createProduct() {
        //GIVEN
        long id = 1;
        String productName = "TestProduct";
        String productDescription = "TestDescription";
        float price = 100;

        //WHEN
        Product expectedProduct = new Product(productName, productDescription, price);
        Mockito.when(productDao.addProduct()).thenReturn(expectedProduct);
        Product product = productService.createProduct(productName, productDescription, price);

    }

    @Test
    public void getProduct() {
    }

    @Test
    public void productList() {
    }
}