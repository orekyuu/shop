package net.orekyuu.shop.identity.domain.model.account;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * アカウント登録画面を開くためのトークン
 */
public class AccountRegistrationToken {
    final String token;
    final LocalDateTime expiredAt;
    final AccountMailAddress address;

    public AccountRegistrationToken(LocalDateTime now, AccountMailAddress address) {
        this.address = address;
        this.token = UUID.randomUUID().toString();
        this.expiredAt = now.plusMinutes(30);
    }

    public String token() {
        return token;
    }

    public AccountMailAddress address() {
        return address;
    }

    public LocalDateTime expiredAt() {
        return expiredAt;
    }
}
