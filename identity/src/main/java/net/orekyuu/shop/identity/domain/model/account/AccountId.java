package net.orekyuu.shop.identity.domain.model.account;

/**
 * アカウントID
 */
public class AccountId {
    final String value;

    public AccountId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
