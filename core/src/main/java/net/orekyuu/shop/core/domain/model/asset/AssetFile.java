package net.orekyuu.shop.core.domain.model.asset;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AssetFile {
    final byte[] bytes;
    final AssetId assetId;

    public AssetFile(byte[] bytes, AssetId assetId) {
        this.bytes = bytes;
        this.assetId = assetId;
    }

    public AssetId id() {
        return assetId;
    }

    public InputStream inputStream() {
        return new ByteArrayInputStream(bytes);
    }
}
