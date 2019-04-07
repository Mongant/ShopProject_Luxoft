package com.gorbunov.dao;


import com.gorbunov.domain.ProductContainer;

import java.util.List;

public interface ProductContainerDao {

    /**
     * Add product on basket <br>
     * @param id customer unique identifier <br>
     * @param refId unique identifier for product container in client session
     * */
    void addProductContainer(long id, String refId);

    /**
     * Delete product on basket <br>
     * @param id customer unique identifier <br>
     * @param refId unique identifier for product container in client session
     * */
    void deleteProductContainerItem(long id, String refId);

    /**
     * Show all product in basket who was added on unique identifier and unique session <br>
     * @param refId unique identifier for product container in client session
     * */
    List<ProductContainer> showProductContainer(String refId);
}
