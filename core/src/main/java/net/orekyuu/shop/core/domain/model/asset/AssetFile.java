package net.orekyuu.shop.core.domain.model.asset;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AssetFile {
    final byte[] bytes;
    final AssetId assetId;
    final String contentType;

    public AssetFile(byte[] bytes, AssetId assetId, String contentType) {
        this.bytes = bytes;
        this.assetId = assetId;
        this.contentType = contentType;
    }

    public AssetId id() {
        return assetId;
    }

    public InputStream inputStream() {
        return new ByteArrayInputStream(bytes);
    }

    public String contentType() {
        return contentType;
    }
}
