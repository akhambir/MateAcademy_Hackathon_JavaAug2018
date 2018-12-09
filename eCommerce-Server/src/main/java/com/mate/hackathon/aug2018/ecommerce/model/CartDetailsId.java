package com.mate.hackathon.aug2018.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Objects;

@Embeddable
public class CartDetailsId {

    @ManyToOne
    private Long fkCartId;
    @ManyToOne
    @Column(name = "FK_PRODUCT_ID")
    @MapsId
    private Product product;

    public static CartDetailsId empty() {
        return new CartDetailsId();
    }

    public Long getFkCartId() {
        return fkCartId;
    }

    public void setFkCartId(Long fkCartId) {
        this.fkCartId = fkCartId;
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
        if (!(o instanceof CartDetailsId)) return false;
        CartDetailsId that = (CartDetailsId) o;
        return Objects.equals(fkCartId, that.fkCartId) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkCartId, product);
    }
}
