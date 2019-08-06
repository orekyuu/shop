package net.orekyuu.shop.web.infrastructure.datasource.product;

import net.orekyuu.shop.core.domain.model.product.*;
import net.orekyuu.shop.core.domain.type.assets.AssetId;
import org.seasar.doma.*;

import java.time.LocalDateTime;

@Entity(immutable = true)
@Table(name = "product_images")
public class ProductImageTable {
    @Id
    @Column
    final AssetId id;
    @Column
    final ProductId productId;
    @Column
    final LocalDateTime createdAt;

    public ProductImageTable(AssetId id, ProductId productId, LocalDateTime createdAt) {
        this.id = id;
        this.productId = productId;
        this.createdAt = createdAt;
    }
}
