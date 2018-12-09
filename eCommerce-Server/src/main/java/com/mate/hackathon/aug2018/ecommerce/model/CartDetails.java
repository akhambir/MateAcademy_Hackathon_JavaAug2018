package com.mate.hackathon.aug2018.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CARTS_DETAILS")
/*@AssociationOverrides({
        @AssociationOverride(name = "cartDetailsId.fkCartId",
                joinColumns = @JoinColumn(name = "FK_CART_ID")),
        @AssociationOverride(name = "cartDetailsId.fkProductId",
                joinColumns = @JoinColumn(name = "FK_PRODUCT_ID")) })*/
public class CartDetails {

    @EmbeddedId
    private CartDetailsId cartDetailsId;
    @Column(name = "QUANTITY")
    private Integer quantity;

    @MapsId("fkCartId")
    @JoinColumn(name = "FK_CARD_ID")
    @ManyToOne
    private Cart cart;

    @MapsId("fkProductId")
    @JoinColumn(name = "FK_PRODUCT_ID")
    @ManyToOne
    private Product product;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
