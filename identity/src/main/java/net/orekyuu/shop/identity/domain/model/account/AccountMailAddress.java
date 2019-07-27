package net.orekyuu.shop.identity.domain.model.account;

/**
 * アカウントに紐づくメールアドレス
 */
public class AccountMailAddress {
    final String value;

    public AccountMailAddress(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
