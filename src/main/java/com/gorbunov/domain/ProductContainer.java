package com.gorbunov.domain;

import java.util.Map;

public class ProductContainer {

    private String refId;
    private Map<Long, Product> productsContainer;

    public ProductContainer(String refId, Map<Long, Product> productsContainer) {
        this.refId = refId;
        this.productsContainer = productsContainer;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public Map<Long, Product> getProductsContainer() {
        return productsContainer;
    }

    public void setProductsContainer(Map<Long, Product> productsContainer) {
        this.productsContainer = productsContainer;
    }
}
