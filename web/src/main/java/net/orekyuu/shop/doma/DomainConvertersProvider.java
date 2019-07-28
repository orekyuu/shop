package net.orekyuu.shop.doma;

import net.orekyuu.shop.identity.domain.model.account.AccountIdConverter;
import net.orekyuu.shop.identity.domain.model.account.AccountMailAddressConverter;
import net.orekyuu.shop.identity.domain.type.EncryptedConverter;
import org.seasar.doma.DomainConverters;

@DomainConverters({
        AccountIdConverter.class,
        AccountMailAddressConverter.class,
        EncryptedConverter.class,

})
public class DomainConvertersProvider {
}
