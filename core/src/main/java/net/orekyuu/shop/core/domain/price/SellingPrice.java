package net.orekyuu.shop.core.domain.price;

import java.math.BigDecimal;

/**
 * 販売価格
 */
public class SellingPrice {

    final WholesalePrice price;
    final ConsumptionTax tax;

    public SellingPrice(WholesalePrice price, ConsumptionTax tax) {
        this.price = price;
        this.tax = tax;
    }

    /**
     * 税込み価格
     */
    public BigDecimal taxIncludedValue() {
        return price.value.add(tax.value);
    }

    /**
     * 税抜き価格
     */
    public BigDecimal taxExcludedValue() {
        return price.value;
    }
}
