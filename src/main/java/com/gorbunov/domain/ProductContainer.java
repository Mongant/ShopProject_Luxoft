package com.gorbunov.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="PRODUCT_CONTAINER")
public class ProductContainer {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "increment")
    private long id;

    @Column(name = "REF_ID")
    private String refId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productContainer", cascade = CascadeType.ALL)
    private List<Product> products;

    public ProductContainer() {
        //for hibernate constructorv
    }

    public ProductContainer(String refId, List<Product> products) {
        this.refId = refId;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductContainer that = (ProductContainer) o;
        return Objects.equals(refId, that.refId) &&
                Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refId, products);
    }
}
