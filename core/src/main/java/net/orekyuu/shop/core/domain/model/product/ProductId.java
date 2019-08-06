package net.orekyuu.shop.core.domain.model.product;

import java.util.Objects;
import java.util.UUID;

/**
 * 作品ID
 */
public class ProductId {
    final Long value;

    @Deprecated
    public ProductId(Long value) {
        this.value = value;
    }

    public Long value() {
        return value;
    }

    public String text() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return value.equals(productId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
