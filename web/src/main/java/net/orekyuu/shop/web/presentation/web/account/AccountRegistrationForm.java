package net.orekyuu.shop.web.presentation.web.account;

import net.orekyuu.shop.identity.domain.model.account.AccountId;
import net.orekyuu.shop.identity.domain.model.account.Password;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AccountRegistrationForm {
    @NotEmpty
    public String username;
    @NotEmpty
    public String password;
    @NotEmpty
    public String passwordConfirm;
    @NotEmpty
    public String token;

    AccountId accountId() {
        return new AccountId(username);
    }

    Password password() {
        return new Password(password);
    }
}
