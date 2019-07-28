package net.orekyuu.shop.web.application.repository.account;

import net.orekyuu.shop.identity.domain.model.account.AccountMailAddress;
import net.orekyuu.shop.identity.domain.model.account.AccountRegistrationLinkMail;
import net.orekyuu.shop.identity.domain.model.account.AccountRegistrationToken;
import net.orekyuu.shop.identity.domain.model.account.AccountRegistrationTokenStore;
import net.orekyuu.shop.web.domain.model.mail.MailService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountRegistrationService {

    final MailService mailService;
    final AccountRegistrationTokenStore tokenStore;

    public AccountRegistrationService(MailService mailService, AccountRegistrationTokenStore tokenStore) {
        this.mailService = mailService;
        this.tokenStore = tokenStore;
    }

    public void sendRegistrationLinkMail(AccountMailAddress address) {
        AccountRegistrationLinkMail mail = new AccountRegistrationLinkMail(address, LocalDateTime.now());

        tokenStore.save(mail.token());
        mailService.send(mail);
    }

    public Optional<AccountMailAddress> findByToken(String token) {
        return tokenStore.find(token).map(AccountRegistrationToken::address);
    }
}
