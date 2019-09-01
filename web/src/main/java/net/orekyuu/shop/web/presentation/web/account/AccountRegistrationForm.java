package net.orekyuu.shop.web.presentation.web.account;

import net.orekyuu.shop.identity.domain.model.account.AccountId;
import net.orekyuu.shop.identity.domain.model.account.Password;

import javax.validation.constraints.AssertTrue;

public class AccountRegistrationForm {
    String username;
    String password;
    String passwordConfirm;
    String token;

    @AssertTrue(message = "ユーザー名を入力してください")
    boolean isUserNameValid() {
        return !username.isBlank();
    }

    @AssertTrue(message = "パスワードを入力してください")
    boolean isPasswordValid() {
        return !password.isBlank();
    }

    @AssertTrue(message = "確認用パスワードに誤りがあります")
    boolean isPasswordConfirmValid() {
        return password.equals(passwordConfirm);
    }

    AccountId accountId() {
        return new AccountId(username);
    }

    Password password() {
        return new Password(password);
    }
}
