package net.orekyuu.shop.core.domain.model.product;

import java.util.Objects;
import java.util.UUID;

/**
 * 作品ID
 */
public class ProductId {
    final String value;

    @Deprecated
    public ProductId(String value) {
        this.value = value;
    }

    public ProductId() {
        this(UUID.randomUUID().toString());
    }

    public String text() {
        return value;
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
