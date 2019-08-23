package net.orekyuu.shop.core.domain.model.asset;

import java.util.List;

public interface AssetRepository {

    default void save(AssetFile file) {
        save(List.of(file));
    }

    void save(Iterable<AssetFile> files);
}
