package net.orekyuu.shop.web.infrastructure.doma;

import org.seasar.doma.DomainConverters;

@DomainConverters({
        AccountIdConverter.class,
        AccountMailAddressConverter.class,
        EncryptedConverter.class,
        ProductIdConverter.class,
        ProductNameConverter.class,
        ProductDescriptionConverter.class,
        CircleIdConverter.class,
        CircleNameConverter.class,
        ReleaseDateConverter.class,
        WholesalePriceConverter.class,
        AssetIdConverter.class,
        CircleHomePageConverter.class,
        CircleSupportMailAddressConverter.class
})
public class DomainConvertersProvider {
}
