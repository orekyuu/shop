package net.orekyuu.shop.web.infrastructure.datasource.account;

import net.orekyuu.shop.identity.domain.model.account.AccountId;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import java.util.List;

@ConfigAutowireable
@Dao
public interface AccountDao {

    @Insert
    Result<AccountTable> insert(AccountTable account);

    @Select
    List<AccountTable> findByIds(Iterable<AccountId> ids);
}
