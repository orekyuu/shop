package net.orekyuu.shop.core.domain.model.circle;

import net.orekyuu.shop.identity.domain.model.account.AccountId;

import java.util.Optional;

/**
 * サークルリポジトリ
 */
public interface CircleRepository {

    Optional<Circle> findById(CircleId id);

    void update(Circle circle);

    CircleId registerCircle(AccountId account, CircleName name, CircleHomePage homePage, CircleSupportMailAddress mailAddress);

    Optional<Circle> findByAccount(AccountId accountId);
}
