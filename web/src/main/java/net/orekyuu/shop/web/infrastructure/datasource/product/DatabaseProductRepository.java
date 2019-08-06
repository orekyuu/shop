package net.orekyuu.shop.web.infrastructure.datasource.product;

import net.orekyuu.shop.core.domain.model.circle.CircleId;
import net.orekyuu.shop.core.domain.model.product.*;

import java.time.LocalDateTime;
import java.util.List;

public class DatabaseProductRepository implements ProductRepository {
    @Override
    public List<Product> findReleasedByIds(LocalDateTime time, Iterable<ProductId> ids) {
        return null;
    }

    @Override
    public List<Product> findByCircle(CircleId circleId) {
        return null;
    }

    @Override
    public ProductId registrationProduct(CircleId circleId, ProductName name, ProductDescription description, ReleaseDate releaseDate, ProductBasePrice price) {
        return null;
    }
}
