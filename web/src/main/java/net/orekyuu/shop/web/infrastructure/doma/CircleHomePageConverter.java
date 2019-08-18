package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.core.domain.model.circle.CircleHomePage;
import org.seasar.doma.ExternalDomain;

@ExternalDomain
public class CircleHomePageConverter extends DomainConverterAdapter<CircleHomePage, String> {
    @SuppressWarnings("deprecation")
    public CircleHomePageConverter() {
        super(CircleHomePage::text, CircleHomePage::new);
    }
}
