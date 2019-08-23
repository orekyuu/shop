package net.orekyuu.shop.core.domain.model.product;

import net.orekyuu.shop.core.domain.model.asset.AssetFile;
import net.orekyuu.shop.core.domain.model.asset.AssetId;

public class ProductImage {
    final AssetFile file;

    public ProductImage(AssetFile file) {
        this.file = file;
    }

    public AssetId id() {
        return file.id();
    }
}
