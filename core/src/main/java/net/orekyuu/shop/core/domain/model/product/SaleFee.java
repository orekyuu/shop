package net.orekyuu.shop.core.domain.model.product;

import net.orekyuu.shop.core.domain.type.amount.Amount;
import net.orekyuu.shop.core.domain.type.amount.Percentage;
import net.orekyuu.shop.core.domain.type.amount.RoundingMode;

/**
 * 販売手数料
 */
public class SaleFee {
    private static final Percentage SALE_FEE_RATE = new Percentage(30);
    final Amount value;

    SaleFee(Amount value) {
        this.value = value;
    }

    public static SaleFee calculate(WholesalePrice price) {
        return new SaleFee(price.value.multiply(SALE_FEE_RATE, RoundingMode.切り上げ));
    }
}
