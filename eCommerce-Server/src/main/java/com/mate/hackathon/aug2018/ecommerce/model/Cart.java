package com.mate.hackathon.aug2018.ecommerce.model;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.CartDto;
import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.ProductDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "CARTS")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId("FK_CUSTOMER_ID")
    private User user;
    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<CartDetails> cartDetails = new ArrayList<>();
    @Column(name = "AMOUNT")
    private Double amount;

    public static Cart of(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setUser(cartDto.getUser());
        cart.setAmount(cartDto.getAmount());

        Map<ProductDto, Integer> products = cartDto.getProducts();

        for (Map.Entry<ProductDto, Integer> productDtoIntegerEntry : products.entrySet()) {
            ProductDto productDto = productDtoIntegerEntry.getKey();
            Product product = Product.of(productDto);
            Integer quantity = productDtoIntegerEntry.getValue();
            cart.setProductAndQuantity(product, quantity);
        }

        return cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<CartDetails> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetails> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public void setProductAndQuantity(Product product, Integer quantity) {

        CartDetails cartDetails = createCartDetails(product);
        cartDetails.setQuantity(quantity);

        if (this.cartDetails.contains(cartDetails)) {
            int index = this.cartDetails.indexOf(cartDetails);
            this.cartDetails.set(index, cartDetails);
        } else {
            this.cartDetails.add(cartDetails);
        }
    }

    public void deleteProduct(Product product) {
        CartDetails cartDetails = createCartDetails(product);
        this.cartDetails.remove(cartDetails);
    }

    private CartDetails createCartDetails(Product product) {
        CartDetails cartDetails = CartDetails.empty();
        CartDetailsId cartDetailsId = CartDetailsId.empty();
        cartDetailsId.setFkCartId(this.getId());
        cartDetails.setProduct(product);
        cartDetailsId.setFkProductId(product.getId());
        cartDetails.setCartDetailsId(cartDetailsId);
        return cartDetails;
    }
}
