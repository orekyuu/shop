package net.orekyuu.shop.identity.domain.model.account;

import java.time.LocalDateTime;

/**
 * アカウント登録用のリンクを送るメール
 */
public class AccountRegistrationLinkMail {

    final AccountMailAddress address;
    final AccountRegistrationToken token;

    public AccountRegistrationLinkMail(AccountMailAddress address, LocalDateTime now) {
        this.address = address;
        this.token = new AccountRegistrationToken(now, address);
    }

    public String address() {
        return address.value;
    }

    public String body() {
        return "以下のリンクからアカウントの登録を行えます。\n" +
                "http://localhost:8080/accounts/registration?token=" + token.token + "\n" +
                "\n" +
                "このメールに身に覚えのない場合は無視してください。";
    }

    public String title() {
        return "【Shop Demo】アカウント登録のお願い";
    }

    public AccountRegistrationToken token() {
        return token;
    }
}
