package net.orekyuu.shop.web.infrastructure.datasource.account;

import net.orekyuu.shop.identity.domain.model.account.Account;
import net.orekyuu.shop.identity.domain.model.account.AccountId;
import net.orekyuu.shop.identity.domain.model.account.AccountMailAddress;
import net.orekyuu.shop.identity.domain.model.account.Password;
import net.orekyuu.shop.identity.domain.type.Encrypted;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(immutable = true)
@Table(name = "accounts")
public class AccountTable {
    @Id
    @Column(name = "id")
    final AccountId id;
    @Column(name = "password")
    final Encrypted<Password> password;
    @Column(name = "mail_address")
    final AccountMailAddress mailAddress;

    public AccountTable(AccountId id, Encrypted<Password> password, AccountMailAddress mailAddress) {
        this.id = id;
        this.password = password;
        this.mailAddress = mailAddress;
    }

    public AccountTable(Account account) {
        this(account.id(), account.password(), account.mail());
    }

    public Account toAccount() {
        return new Account(id, password, mailAddress);
    }
}
