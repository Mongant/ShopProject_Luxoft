package com.gorbunov.dao.impl;

import com.gorbunov.dao.ProductContainerDao;
import com.gorbunov.dao.dbcp.DataBaseConnection;

public class ProductContainerDaoImpl implements ProductContainerDao {

    DataBaseConnection dbConnection = new DataBaseConnection();
    private static ProductContainerDao productContainerDao = null;

    private ProductContainerDaoImpl() {
    }

    public static ProductContainerDao getInstance() {
        if(productContainerDao == null) {
            productContainerDao = new ProductContainerDaoImpl();
        }
        return productContainerDao;
    }

    @Override
    public void addProductContainer(long id, String ref) {
        String sql = "insert into SHOP.PRODUCT_CONTAINER (REF_ID, PRODUCT_ID) values('" + ref + "', " + id + ");";
        dbConnection.sqlStatement(sql);
    }

    @Override
    public void updateProductConteiner(long id, String ref) {

    }

    @Override
    public void deleteProductConteiner(long id, String refId) {
        String sql = "delete from SHOP.PRODUCT_CONTAINER where REF_ID = '" + refId + "' and ID = " + id + ";";
        dbConnection.sqlStatement(sql);
    }


}
