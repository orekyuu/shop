package net.orekyuu.shop.core.domain.price;

import java.math.BigDecimal;

/**
 * 卸価格
 */
public class WholesalePrice {
    final BigDecimal value;

    public WholesalePrice(BigDecimal value) {
        this.value = value;
    }

    public WholesalePrice(long value) {
        this(BigDecimal.valueOf(value));
    }

}
