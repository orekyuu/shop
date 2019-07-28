package net.orekyuu.shop.web.infrastructure.security;

import net.orekyuu.shop.identity.domain.model.account.Account;
import net.orekyuu.shop.identity.domain.model.account.AccountId;
import net.orekyuu.shop.web.domain.model.account.AccountRepository;
import net.orekyuu.shop.web.domain.model.account.ShopUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ShopUserDetailsService implements UserDetailsService {
    final AccountRepository accountRepository;

    public ShopUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findById(new AccountId(username))
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found."));
        return new ShopUserDetails(account);
    }
}
