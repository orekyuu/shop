package net.orekyuu.shop.core.domain.model.product;

import net.orekyuu.shop.core.domain.type.amount.Amount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductBasePriceTest {

    @Test
    void 基本料金が求められる() {
        WholesalePrice wholesalePrice = new WholesalePrice(new Amount(1000));
        SaleFee saleFee = SaleFee.calculate(wholesalePrice);
        ProductBasePrice basePrice = new ProductBasePrice(wholesalePrice, saleFee);

        assertThat(basePrice.taxExcluded()).isEqualByComparingTo(new Amount(1300));
        assertThat(basePrice.taxIncluded()).isEqualByComparingTo(new Amount(1404));
    }
}