package com.gorbunov.services.impl;

import com.gorbunov.dao.ProductContainerDao;
import com.gorbunov.dao.impl.ProductContainerDaoImpl;
import com.gorbunov.domain.ProductContainer;
import com.gorbunov.services.ProductContainerService;

public class ProductContainerServiceImpl implements ProductContainerService {

    ProductContainerDao productContainerDao = ProductContainerDaoImpl.getInstance();

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
