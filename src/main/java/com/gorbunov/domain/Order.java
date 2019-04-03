package com.gorbunov.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "increment")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Client client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productContainer", cascade = CascadeType.ALL)
    private List<Product> products;
    private float amount;

    public Order() {
        //for hibernate constructor
    }

    public Order(long id, Client client, List<Product> products, float amount) {
        this.id = id;
        this.client = client;
        this.products = products;
        this.amount = amount;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Float.compare(order.amount, amount) == 0 &&
                Objects.equals(client, order.client) &&
                Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, products, amount);
    }
}
