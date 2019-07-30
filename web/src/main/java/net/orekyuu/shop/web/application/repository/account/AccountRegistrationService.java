package net.orekyuu.shop.web.application.repository.account;

import net.orekyuu.shop.identity.domain.model.account.*;
import net.orekyuu.shop.identity.domain.type.Encrypted;
import net.orekyuu.shop.identity.domain.model.account.AccountRepository;
import net.orekyuu.shop.identity.domain.model.mail.MailService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class AccountRegistrationService {

    final MailService mailService;
    final AccountRegistrationTokenStore tokenStore;
    final PasswordEncoder encoder;
    final AccountRepository accountRepository;

    public AccountRegistrationService(MailService mailService, AccountRegistrationTokenStore tokenStore, PasswordEncoder encoder, AccountRepository accountRepository) {
        this.mailService = mailService;
        this.tokenStore = tokenStore;
        this.encoder = encoder;
        this.accountRepository = accountRepository;
    }

    public void sendRegistrationLinkMail(AccountMailAddress address) {
        AccountRegistrationLinkMail mail = new AccountRegistrationLinkMail(address, LocalDateTime.now());

        tokenStore.save(mail.token());
        mailService.send(mail);
    }

    public Optional<AccountMailAddress> findByToken(String token) {
        return tokenStore.find(token).map(AccountRegistrationToken::address);
    }

    public Account registration(AccountId accountId, Password password, String token) {
        AccountRegistrationToken registrationToken = tokenStore.find(token).orElseThrow(InvalidMailTokenException::new);
        Account account = new Account(accountId, Encrypted.from(password, it -> encoder.encode(it.toString()).getBytes(StandardCharsets.UTF_8)), registrationToken.address());
        accountRepository.insert(account);
        tokenStore.consume(token);
        return account;
    }
}
