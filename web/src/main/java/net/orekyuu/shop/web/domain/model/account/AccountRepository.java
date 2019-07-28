package net.orekyuu.shop.web.domain.model.account;

import net.orekyuu.shop.identity.domain.model.account.Account;
import net.orekyuu.shop.identity.domain.model.account.AccountId;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findById(AccountId id);
}
