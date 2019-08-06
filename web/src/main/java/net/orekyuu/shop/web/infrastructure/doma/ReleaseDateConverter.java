package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.core.domain.model.product.ReleaseDate;
import org.seasar.doma.ExternalDomain;

import java.time.LocalDate;

@ExternalDomain
public class ReleaseDateConverter extends DomainConverterAdapter<ReleaseDate, LocalDate> {
    public ReleaseDateConverter() {
        super(ReleaseDate::date, ReleaseDate::new);
    }
}
