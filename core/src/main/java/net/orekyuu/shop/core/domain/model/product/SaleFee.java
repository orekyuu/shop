package net.orekyuu.shop.core.domain.model.product;

import net.orekyuu.shop.core.domain.model.price.SellingPrice;

import java.math.BigDecimal;

/**
 * 販売手数料
 */
public class SaleFee {
    private static final BigDecimal SALE_FEE_RATE = BigDecimal.valueOf(0.3);
    final BigDecimal value;

    SaleFee(BigDecimal value) {
        this.value = value;
    }

    public static SaleFee of(SellingPrice price) {
        return new SaleFee(price.taxIncludedValue().multiply(SALE_FEE_RATE));
    }
}
