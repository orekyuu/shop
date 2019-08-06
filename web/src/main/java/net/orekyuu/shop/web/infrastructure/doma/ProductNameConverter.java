package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.core.domain.model.product.ProductName;
import org.seasar.doma.ExternalDomain;

@ExternalDomain
public class ProductNameConverter extends DomainConverterAdapter<ProductName, String> {
    public ProductNameConverter() {
        super(ProductName::text, ProductName::new);
    }
}