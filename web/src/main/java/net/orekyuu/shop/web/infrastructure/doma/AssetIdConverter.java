package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.core.domain.type.assets.AssetId;
import org.seasar.doma.ExternalDomain;

@ExternalDomain
public class AssetIdConverter extends DomainConverterAdapter<AssetId, String> {
    @SuppressWarnings("deprecation")
    public AssetIdConverter() {
        super(AssetId::value, AssetId::new);
    }
}
