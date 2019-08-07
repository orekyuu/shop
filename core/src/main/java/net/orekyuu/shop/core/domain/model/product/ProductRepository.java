package net.orekyuu.shop.core.domain.model.product;

import net.orekyuu.shop.core.domain.model.circle.CircleId;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 作品リポジトリ
 */
public interface ProductRepository {

    List<Product> findByIds(Iterable<ProductId> ids);

    List<Product> findByCircle(CircleId circleId);

    ProductId registrationProduct(CircleId circleId, ProductName name, ProductDescription description, ReleaseDate releaseDate, WholesalePrice price, ProductImages images);
}
