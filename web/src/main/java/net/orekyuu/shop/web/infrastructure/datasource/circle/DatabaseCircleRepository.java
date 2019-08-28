package net.orekyuu.shop.web.infrastructure.datasource.circle;

import net.orekyuu.shop.core.domain.model.circle.*;
import net.orekyuu.shop.identity.domain.model.account.AccountId;
import net.orekyuu.shop.web.infrastructure.util.Collector2;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class DatabaseCircleRepository implements CircleRepository {
    final CircleDao dao;

    public DatabaseCircleRepository(CircleDao dao) {
        this.dao = dao;
    }

    @Override
    public Optional<Circle> findById(CircleId id) {
        return Optional.empty();
    }

    @Override
    public void update(Circle circle) {

    }

    @Override
    public CircleId registerCircle(AccountId account, CircleName name, CircleHomePage homePage, CircleSupportMailAddress mailAddress) {
        CircleTable table = new CircleTable(null, name, homePage, mailAddress, LocalDateTime.now(), account);
        return dao.insert(table).getEntity().id;
    }

    @Override
    public Optional<Circle> findByAccount(AccountId accountId) {
        return dao.findByAccountIds(List.of(accountId), Collector2.toOptional()).map(CircleTable::toCircle);
    }
}
