package net.orekyuu.shop.core.domain.model.circle;

import java.util.Optional;

/**
 * サークルリポジトリ
 */
public interface CircleRepository {

    Optional<Circle> findById(CircleId id);

    void update(Circle circle);

    Circle registerCircle(CircleName name);
}
