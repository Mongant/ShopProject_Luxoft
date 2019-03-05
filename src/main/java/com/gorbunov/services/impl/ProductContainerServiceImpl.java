package com.gorbunov.services.impl;

import com.gorbunov.dao.ProductContainerDao;
import com.gorbunov.dao.impl.ProductContainerDaoImpl;
import com.gorbunov.services.ProductContainerService;

public class ProductContainerServiceImpl implements ProductContainerService {

    ProductContainerDao productContainerDao = ProductContainerDaoImpl.getInstance();

    @Override
    public void addProductContainer(long id, String ref) {
        productContainerDao.addProductContainer(id, ref);
    }
}
