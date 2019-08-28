package net.orekyuu.shop.core.domain.model.asset;

import java.net.URL;
import java.util.List;
import java.util.Optional;

public interface AssetRepository {

    default void uploadPublicImageFile(AssetFile file) {
        uploadPublicImageFile(List.of(file));
    }

    void uploadPublicImageFile(Iterable<AssetFile> files);

    void uploadPrivateZipFile(AssetFile file);

    void uploadPublicZipFile(AssetFile file);

    Optional<String> findPublicUrlByAssetId(AssetId assetId);
}
