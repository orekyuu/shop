package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.core.domain.model.product.WholesalePrice;
import net.orekyuu.shop.core.domain.type.amount.Amount;
import org.seasar.doma.ExternalDomain;

import java.math.BigDecimal;

@ExternalDomain
public class WholesalePriceConverter extends DomainConverterAdapter<WholesalePrice, BigDecimal> {
    @SuppressWarnings("deprecation")
    public WholesalePriceConverter() {
        super(wholesalePrice -> wholesalePrice.value().value(), bigDecimal -> new WholesalePrice(new Amount(bigDecimal)));
    }
}
