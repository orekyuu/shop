package net.orekyuu.shop.core.domain.model.product;

import net.orekyuu.shop.core.domain.type.assets.AssetId;

public class ProductImage {
    final AssetId imageId;

    public ProductImage(AssetId imageId) {
        this.imageId = imageId;
    }
}
