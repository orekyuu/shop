package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.core.domain.model.product.ProductId;
import org.seasar.doma.ExternalDomain;

@ExternalDomain
public class ProductIdConverter extends DomainConverterAdapter<ProductId, Long> {
    @SuppressWarnings("deprecation")
    public ProductIdConverter() {
        super(ProductId::value, ProductId::new);
    }
}
