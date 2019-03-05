package com.gorbunov.domain;

import java.util.List;

public class ProductContainer {

    private long id;
    private long clientId;
    private String refId;
    private List<Product> products;

    public ProductContainer(long id, long clientId, String refId, List<Product> products) {
        this.id = id;
        this.clientId = clientId;
        this.refId = refId;
        this.products = products;
    }

    public ProductContainer(long clientId, String refId, List<Product> products) {
        this.clientId = clientId;
        this.refId = refId;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductContainer{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", refId='" + refId + '\'' +
                ", products=" + products +
                '}';
    }
}
