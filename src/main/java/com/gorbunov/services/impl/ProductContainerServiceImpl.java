package com.gorbunov.services.impl;

import com.gorbunov.dao.ProductContainerDao;
import com.gorbunov.domain.Product;
import com.gorbunov.domain.ProductContainer;
import com.gorbunov.services.ProductContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductContainerServiceImpl implements ProductContainerService {

    @Autowired
    ProductContainerDao productContainerDao;

    @Override
    public void addProductContainer(long id, String ref) {
        productContainerDao.addProductContainer(id, ref);
    }

    @Override
    public void deleteProductContainer(long id, String refId) {
        productContainerDao.deleteProductContainerItem(id, refId);
    }

    @Override
    public List<Product> showProductContainer(String refId) {
        List<Product> products = new ArrayList<>();
        for(ProductContainer productContainer : productContainerDao.showProductContainer(refId)) {
            products.add(productContainer.getProduct());
        }
        return products;
    }
}
