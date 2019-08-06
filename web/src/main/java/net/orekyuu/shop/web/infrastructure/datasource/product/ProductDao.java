package net.orekyuu.shop.web.infrastructure.datasource.product;

import net.orekyuu.shop.core.domain.model.circle.CircleId;
import net.orekyuu.shop.core.domain.model.product.ProductId;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import java.util.List;
import java.util.stream.Collector;

@Dao
@ConfigAutowireable
public interface ProductDao {

    @Select(strategy = SelectType.COLLECT)
    <T> T findById(Iterable<ProductId> ids, Collector<ProductEntity, ?, T> collector);

    default <T> T findById(ProductId id, Collector<ProductEntity, ?, T> collector) {
        return findById(List.of(id), collector);
    }

    @Select(strategy = SelectType.COLLECT)
    <T> T findByCircleId(Iterable<CircleId> ids, Collector<ProductEntity, ?, T> collector);

    default <T> T findByCircleId(CircleId id, Collector<ProductEntity, ?, T> collector) {
        return findByCircleId(List.of(id), collector);
    }

    @Insert
    Result<ProductTable> insertProduct(ProductTable product);

    @Insert
    Result<ProductImageTable> insertImage(ProductImageTable table);
}
