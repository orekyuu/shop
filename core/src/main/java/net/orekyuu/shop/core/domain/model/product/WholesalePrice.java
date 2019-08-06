package net.orekyuu.shop.core.domain.model.product;

import net.orekyuu.shop.core.domain.type.amount.Amount;

/**
 * 卸価格
 *
 * サークルの利益分となる金額。販売手数料を上乗せしたものが販売価格となる
 */
public class WholesalePrice {
    final Amount value;

    public WholesalePrice(Amount value) {
        this.value = value;
    }

    public Amount value() {
        return value;
    }
}
