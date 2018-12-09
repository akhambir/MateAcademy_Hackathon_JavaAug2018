package com.mate.hackathon.aug2018.ecommerce.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartDetailsId implements Serializable {

    private Long fkCartId;
    private Long fkProductId;

    public static CartDetailsId empty() {
        return new CartDetailsId();
    }

    public Long getFkCartId() {
        return fkCartId;
    }

    public void setFkCartId(Long fkCartId) {
        this.fkCartId = fkCartId;
    }

    public Long getFkProductId() {
        return fkProductId;
    }

    public void setFkProductId(Long fkProductId) {
        this.fkProductId = fkProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartDetailsId)) return false;
        CartDetailsId that = (CartDetailsId) o;
        return Objects.equals(fkCartId, that.fkCartId) &&
                Objects.equals(fkProductId, that.fkProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkCartId, fkProductId);
    }
}
