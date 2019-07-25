package net.orekyuu.shop.core.domain.price;

import java.math.BigDecimal;

/**
 * 消費税
 */
public class ConsumptionTax {
    /**
     * 消費税の税率
     */
    private static final BigDecimal TAX_RATE = BigDecimal.valueOf(0.08);
    final BigDecimal value;

    private ConsumptionTax(BigDecimal value) {
        this.value = value;
    }

    public static ConsumptionTax of(WholesalePrice price) {
        return new ConsumptionTax(price.value.multiply(TAX_RATE));
    }
}
