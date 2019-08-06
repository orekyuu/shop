package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.core.domain.model.circle.CircleId;
import org.seasar.doma.ExternalDomain;

@ExternalDomain
public class CircleIdConverter extends DomainConverterAdapter<CircleId, Long> {
    @SuppressWarnings("deprecation")
    public CircleIdConverter() {
        super(CircleId::value, CircleId::new);
    }
}
