package com.gorbunov.services.impl;

import com.gorbunov.dao.ProductContainerDao;
import com.gorbunov.domain.ProductContainer;
import com.gorbunov.services.ProductContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductContainerServiceImpl implements ProductContainerService {

    @Autowired
    ProductContainerDao productContainerDao;

    @Override
    public void addProductContainer(long id, String ref) {
        productContainerDao.addProductContainer(id, ref);
    }

    @Override
    public ProductContainer getProductContainerItem(long id, String refId) throws NullPointerException {
        return productContainerDao.getProductContainerItem(id, refId);
    }

    @Override
    public void deleteProductContainer(long id, String refId) {
        productContainerDao.deleteProductContainerItem(id, refId);
    }

    @Override
    public ProductContainer showProductContainer(String refId) {
        return  productContainerDao.showProductContainer(refId);
    }
}
