package net.orekyuu.shop.identity.domain.model.account;

import java.util.Optional;

public interface AccountRegistrationTokenStore {

    void save(AccountRegistrationToken token);

    Optional<AccountRegistrationToken> consume(String token);

    Optional<AccountRegistrationToken> find(String token);
}
