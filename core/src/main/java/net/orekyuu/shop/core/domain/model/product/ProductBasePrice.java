package net.orekyuu.shop.core.domain.model.product;

import net.orekyuu.shop.core.domain.type.amount.Amount;
import net.orekyuu.shop.core.domain.type.amount.Percentage;
import net.orekyuu.shop.core.domain.type.amount.RoundingMode;

/**
 * 作品の基本価格
 *
 * 卸価格と販売手数料をあわせた販売価格の基本となる価格。ここにキャンペーンやクーポンなどの割引がかかる
 */
public class ProductBasePrice {
    final WholesalePrice value;
    final SaleFee fee;

    public ProductBasePrice(WholesalePrice value, SaleFee fee) {
        this.value = value;
        this.fee = fee;
    }

    public ProductBasePrice(WholesalePrice value) {
        this.value = value;
        this.fee = SaleFee.calculate(value);
    }

    /**
     * 税込価格
     */
    public Amount taxIncluded() {
        Amount taxExcluded = taxExcluded();
        return taxExcluded.multiply(Percentage.CONSUMPTION_TAX, RoundingMode.切り上げ).add(taxExcluded);
    }

    /**
     * 税抜価格
     */
    public Amount taxExcluded() {
        return value.value.add(fee.value);
    }
}
