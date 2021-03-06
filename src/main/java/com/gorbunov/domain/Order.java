package com.gorbunov.domain;

import java.util.List;

public class Order {

    private long id;
    private Client client;
    private List<Product> products;
    private float amount;

    public Order(Client client, List<Product> products, float amount) {
        this.client = client;
        this.products = products;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", products=" + products +
                ", amount=" + amount +
                '}';
    }
}
