package net.orekyuu.shop.web.infrastructure.datasource.account;

import net.orekyuu.shop.identity.domain.model.account.Account;
import net.orekyuu.shop.identity.domain.model.account.AccountId;
import net.orekyuu.shop.identity.domain.model.account.AccountMailAddress;
import net.orekyuu.shop.identity.domain.model.account.Password;
import net.orekyuu.shop.identity.domain.type.Encrypted;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AccountDaoTest {

    @Autowired
    AccountDao dao;
    @Autowired
    PasswordEncoder encoder;

    Function<Password, String> func = pass -> encoder.encode(pass.rawText());

    Account orekyuuAccount;

    @BeforeEach
    void setup() {
        orekyuuAccount = new Account(
                new AccountId("orekyuu"),
                Encrypted.from(new Password("password"), func),
                new AccountMailAddress("orekyuu@sample.test"));
    }

    @Test
    void 新しいレコードを追加できる() {
        dao.insert(new AccountTable(orekyuuAccount));
    }

    @Test
    void idで検索できる() {
        dao.insert(new AccountTable(orekyuuAccount));

        List<AccountTable> result = dao.findByIds(List.of(orekyuuAccount.id()));
        assertThat(result).satisfies(it -> {
            assertThat(it).hasSize(1);
            assertThat(it.get(0).id).isEqualTo(orekyuuAccount.id());
        });
    }
}