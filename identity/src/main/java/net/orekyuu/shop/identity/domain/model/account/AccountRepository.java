package net.orekyuu.shop.identity.domain.model.account;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findById(AccountId id);

    void insert(Account account);
}
