package com.gorbunov.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="PRODUCT_CONTAINER")
public class ProductContainer {

    @Id
    @Column(name = "ID", nullable=false)
    @GeneratedValue(generator = "increment")
    private long id;

    @Column(name = "REF_ID")
    private String refId;

    @ManyToOne
    @JoinColumn(name="REF_ID", nullable=false, insertable = false, updatable = false)
    private Order order;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Product product;

    public ProductContainer() {
        //for hibernate constructor
    }

    public ProductContainer(String refId, Product product) {
        this.refId = refId;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductContainer that = (ProductContainer) o;
        return Objects.equals(refId, that.refId) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refId, product);
    }
}
