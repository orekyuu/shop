package net.orekyuu.shop.web.infrastructure.doma;

import org.seasar.doma.DomainConverters;

@DomainConverters({
        AccountIdConverter.class,
        AccountMailAddressConverter.class,
        EncryptedConverter.class,
})
public class DomainConvertersProvider {
}
