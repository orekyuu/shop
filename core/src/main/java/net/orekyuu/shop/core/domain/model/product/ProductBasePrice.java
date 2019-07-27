package net.orekyuu.shop.core.domain.model.product;

import net.orekyuu.shop.core.domain.model.price.SellingPrice;

import java.math.BigDecimal;

/**
 * 作品の基本価格
 */
public class ProductBasePrice {
    final SellingPrice value;
    final SaleFee fee;

    public ProductBasePrice(SellingPrice value) {
        this.value = value;
        this.fee = SaleFee.of(value);
    }

    public BigDecimal value() {
        return value.taxIncludedValue().add(fee.value);
    }
}
