package com.gorbunov.services;

import com.gorbunov.domain.Product;
import com.gorbunov.domain.ProductContainer;

import java.util.List;

public interface ProductContainerService {

    /**
     * Add new product on basket <br>
     * @param id customer unique identifier <br>
     * @param refId unique identifier for product container in client session
     * */
    void addProductContainer(long id, String refId);

    /**
     * Delete product on basket <br>
     * @param id customer unique identifier <br>
     * @param refId unique identifier for product container in client session
     * */
    void deleteProductContainer(long id, String refId);

    /**
     * Show product container <br>
     * @param refId unique identifier for product container in client session
     * */
   List<Product> showProductContainer(String refId);
}
