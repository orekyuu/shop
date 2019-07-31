package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.identity.domain.model.account.AccountMailAddress;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class AccountMailAddressConverter implements DomainConverter<AccountMailAddress, String> {
    @Override
    public String fromDomainToValue(AccountMailAddress accountMailAddress) {
        return accountMailAddress.value();
    }

    @Override
    public AccountMailAddress fromValueToDomain(String value) {
        if (value == null) {
            return null;
        }

        return new AccountMailAddress(value);
    }
}
