package net.orekyuu.shop.web.infrastructure.datasource.circle;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

@Dao
@ConfigAutowireable
public interface CircleDao {

    @Insert
    Result<CircleTable> insert(CircleTable circle);
}
