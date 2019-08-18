package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.core.domain.model.circle.CircleSupportMailAddress;
import org.seasar.doma.ExternalDomain;

@ExternalDomain
public class CircleSupportMailAddressConverter extends DomainConverterAdapter<CircleSupportMailAddress, String> {
    @SuppressWarnings("deprecation")
    public CircleSupportMailAddressConverter() {
        super(CircleSupportMailAddress::text, CircleSupportMailAddress::new);
    }
}
