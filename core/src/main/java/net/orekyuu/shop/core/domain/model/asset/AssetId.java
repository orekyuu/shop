package net.orekyuu.shop.core.domain.model.asset;

import java.util.UUID;

public class AssetId {
    final String value;

    public AssetId() {
        this.value = UUID.randomUUID().toString();
    }

    @Deprecated
    public AssetId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
