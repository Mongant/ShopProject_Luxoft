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

    @OneToMany(mappedBy = "order")
    private List<ProductContainer> productContainers;

    private float amount;

    public Order() {
        //for hibernate constructor
    }

    public Order(long id, Client client, List<ProductContainer> productContainers, float amount) {
        this.id = id;
        this.client = client;
        this.productContainers = productContainers;
        this.amount = amount;
    }

    public Order(Client client, List<ProductContainer> productContainers, float amount) {
        this.client = client;
        this.productContainers = productContainers;
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

    public List<ProductContainer> getProductContainers() {
        return productContainers;
    }

    public void setProductContainers(List<ProductContainer> productContainers) {
        this.productContainers = productContainers;
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
                ", productContainers=" + productContainers +
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
                Objects.equals(productContainers, order.productContainers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, productContainers, amount);
    }
}
