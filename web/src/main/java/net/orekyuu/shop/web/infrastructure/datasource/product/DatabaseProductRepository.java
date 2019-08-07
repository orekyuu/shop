package net.orekyuu.shop.web.infrastructure.datasource.product;

import net.orekyuu.shop.core.domain.model.circle.CircleId;
import net.orekyuu.shop.core.domain.model.product.*;
import net.orekyuu.shop.web.infrastructure.util.Collector2;
import org.seasar.doma.jdbc.Result;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class DatabaseProductRepository implements ProductRepository {
    final ProductDao dao;
    private static final Collector<ProductEntity, ?, List<Product>> MAPPER = Collector2.mapping(
            it -> it.id,
            ProductEntity::toProduct,
            (a, b) -> {
                a.addImage(b.images());
                return a;
            }
    );

    public DatabaseProductRepository(ProductDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Product> findByIds(Iterable<ProductId> ids) {
        return dao.findById(ids, MAPPER);
    }

    @Override
    public List<Product> findByCircle(CircleId circleId) {
        return dao.findByCircleId(circleId, MAPPER);
    }

    @Override
    public ProductId registrationProduct(CircleId circleId, ProductName name, ProductDescription description, ReleaseDate releaseDate, WholesalePrice price, ProductImages images) {
        LocalDateTime now = LocalDateTime.now();
        Result<ProductTable> result = dao.insertProduct(new ProductTable(name, description, circleId, releaseDate, price, now));
        ProductId productId = result.getEntity().id;
        List<ProductImageTable> imageTables = images.stream().map(it -> new ProductImageTable(it.id(), productId, now)).collect(Collectors.toList());
        dao.insertImage(imageTables);
        return result.getEntity().id;
    }
}
