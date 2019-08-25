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

    public String url() {
        return "http://localhost:9000/shop-demo/" + id().value();
    }
}
