package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.identity.domain.model.account.AccountId;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class AccountIdConverter implements DomainConverter<AccountId, String> {
    @Override
    public String fromDomainToValue(AccountId accountId) {
        return accountId.value();
    }

    @Override
    public AccountId fromValueToDomain(String value) {
        if (value == null) {
            return null;
        }
        return new AccountId(value);
    }
}
