package com.gorbunov.domain;

import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductContainer that = (ProductContainer) o;
        return Objects.equals(refId, that.refId) &&
                Objects.equals(productsContainer, that.productsContainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refId, productsContainer);
    }
}
