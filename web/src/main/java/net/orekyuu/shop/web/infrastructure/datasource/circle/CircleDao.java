package net.orekyuu.shop.web.infrastructure.datasource.circle;

import net.orekyuu.shop.identity.domain.model.account.AccountId;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import java.util.stream.Collector;

@Dao
@ConfigAutowireable
public interface CircleDao {

    @Insert
    Result<CircleTable> insert(CircleTable circle);

    @Select(strategy = SelectType.COLLECT)
    <T> T findByAccountIds(Iterable<AccountId> ids, Collector<CircleTable, ?, T> collector);
}
