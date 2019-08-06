package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.core.domain.model.product.ProductDescription;
import org.seasar.doma.ExternalDomain;

@ExternalDomain
public class ProductDescriptionConverter extends DomainConverterAdapter<ProductDescription, String> {
    public ProductDescriptionConverter() {
        super(ProductDescription::text, ProductDescription::new);
    }
}