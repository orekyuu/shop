package net.orekyuu.shop.core.domain.model.asset;

import java.util.UUID;

public class AssetId {
    final String value;

    public AssetId() {
        this.value = UUID.randomUUID().toString();
    }

    public static AssetId fromFileName(String fileName) {
        String id = UUID.randomUUID().toString();
        if (fileName != null) {
            id = id + "_" + fileName;
        }
        return new AssetId(id);
    }

    @Deprecated
    public AssetId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
