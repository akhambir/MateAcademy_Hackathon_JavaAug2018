package com.mate.hackathon.aug2018.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CARTS_DETAILS")
@AssociationOverrides({
        @AssociationOverride(name = "cartDetailsId.fkCartId",
                joinColumns = @JoinColumn(name = "FK_CART_ID")),
        @AssociationOverride(name = "cartDetailsId.product",
                joinColumns = @JoinColumn(name = "FK_PRODUCT_ID")) })
public class CartDetails {

    @EmbeddedId
    private CartDetailsId cartDetailsId = new CartDetailsId();
    @Column(name = "QUANTITY")
    private Integer quantity;

    public CartDetailsId getCartDetailsId() {
        return cartDetailsId;
    }

    public void setCartDetailsId(CartDetailsId cartDetailsId) {
        this.cartDetailsId = cartDetailsId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static CartDetails empty() {
        return new CartDetails();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartDetails)) return false;
        CartDetails that = (CartDetails) o;
        return Objects.equals(cartDetailsId, that.cartDetailsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartDetailsId);
    }
}
