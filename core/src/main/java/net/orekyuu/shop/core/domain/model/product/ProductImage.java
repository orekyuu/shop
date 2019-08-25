package net.orekyuu.shop.core.domain.model.product;

import net.orekyuu.shop.core.domain.model.asset.AssetId;

public class ProductImage {
    final AssetId file;

    public ProductImage(AssetId file) {
        this.file = file;
    }

    public AssetId id() {
        return file;
    }
}
