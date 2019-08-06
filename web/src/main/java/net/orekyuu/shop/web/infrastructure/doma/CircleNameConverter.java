package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.core.domain.model.circle.CircleName;
import org.seasar.doma.ExternalDomain;

@ExternalDomain
public class CircleNameConverter extends DomainConverterAdapter<CircleName, String> {
    public CircleNameConverter() {
        super(CircleName::text, CircleName::new);
    }
}
