package net.orekyuu.shop.identity.domain.model.account;

import net.orekyuu.shop.identity.domain.type.Encrypted;

/**
 * アカウント
 */
public class Account {
    final AccountId id;
    final Encrypted<Password> password;
    final AccountMailAddress mailAddress;

    public Account(AccountId id, Encrypted<Password> password, AccountMailAddress mailAddress) {
        this.id = id;
        this.password = password;
        this.mailAddress = mailAddress;
    }

    public Encrypted<Password> password() {
        return password;
    }

    public AccountId id() {
        return id;
    }

    public AccountMailAddress mail() {
        return mailAddress;
    }
}
