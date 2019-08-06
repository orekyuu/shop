package net.orekyuu.shop.web.infrastructure.datasource.product;

import net.orekyuu.shop.core.domain.model.circle.CircleId;
import net.orekyuu.shop.core.domain.model.product.*;
import net.orekyuu.shop.core.domain.type.assets.AssetId;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;

import java.time.LocalDateTime;

@Entity(immutable = true)
public class ProductEntity {
    @Column(name = "product_id")
    final ProductId id;
    @Column
    final ProductName name;
    @Column
    final ProductDescription description;
    @Column
    final CircleId circleId;
    @Column
    final ReleaseDate releaseDate;
    @Column
    final WholesalePrice wholesalePrice;
    @Column
    final LocalDateTime registeredAt;
    @Column(name = "image_id")
    final AssetId productImageId;
    @Column(name = "created_at")
    final LocalDateTime imageCreatedAt;

    public ProductEntity(ProductId id, ProductName name, ProductDescription description, CircleId circleId, ReleaseDate releaseDate, WholesalePrice wholesalePrice, LocalDateTime registeredAt, AssetId productImageId, LocalDateTime imageCreatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.circleId = circleId;
        this.releaseDate = releaseDate;
        this.wholesalePrice = wholesalePrice;
        this.registeredAt = registeredAt;
        this.productImageId = productImageId;
        this.imageCreatedAt = imageCreatedAt;
    }
}
