package net.orekyuu.shop.web.infrastructure.datasource.product;

import net.orekyuu.shop.core.domain.model.circle.CircleId;
import net.orekyuu.shop.core.domain.model.product.*;
import net.orekyuu.shop.core.domain.type.assets.AssetId;
import org.seasar.doma.*;

import java.time.LocalDateTime;

@Entity(immutable = true)
@Table(name = "products")
public class ProductTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
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

    public ProductTable(ProductId id, ProductName name, ProductDescription description, CircleId circleId, ReleaseDate releaseDate, WholesalePrice wholesalePrice, LocalDateTime registeredAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.circleId = circleId;
        this.releaseDate = releaseDate;
        this.wholesalePrice = wholesalePrice;
        this.registeredAt = registeredAt;
    }

    public ProductTable(ProductName name, ProductDescription description, CircleId circleId, ReleaseDate releaseDate, WholesalePrice price, LocalDateTime registeredAt) {
        this(null, name, description, circleId, releaseDate, price, registeredAt);
    }

    public ProductImageTable createImage(LocalDateTime time) {
        return new ProductImageTable(new AssetId(), id, time);
    }
}
