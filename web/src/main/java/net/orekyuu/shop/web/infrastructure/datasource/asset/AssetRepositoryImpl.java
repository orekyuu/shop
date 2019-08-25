package net.orekyuu.shop.web.infrastructure.datasource.asset;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import net.orekyuu.shop.core.domain.model.asset.AssetFile;
import net.orekyuu.shop.core.domain.model.asset.AssetId;
import net.orekyuu.shop.core.domain.model.asset.AssetRepository;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.util.Optional;

@Repository
public class AssetRepositoryImpl implements AssetRepository {
    final AmazonS3 amazonS3;

    public AssetRepositoryImpl(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    @Override
    public void uploadPublicImageFile(Iterable<AssetFile> files) {
        files.forEach(f -> {
            AccessControlList accessControlList = new AccessControlList();
            accessControlList.grantPermission(GroupGrantee.AllUsers, Permission.Read);

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(f.contentType());
            PutObjectRequest request = new PutObjectRequest("shop-demo", f.id().value(), f.inputStream(), metadata)
                    .withAccessControlList(accessControlList);
            amazonS3.putObject(request);
        });
    }

    @Override
    public void uploadPrivateZipFile(AssetFile file) {
        AccessControlList accessControlList = new AccessControlList();
        accessControlList.grantPermission(GroupGrantee.AuthenticatedUsers, Permission.Read);
        uploadZipFile(file, accessControlList);
    }

    @Override
    public void uploadPublicZipFile(AssetFile file) {
        AccessControlList accessControlList = new AccessControlList();
        accessControlList.grantPermission(GroupGrantee.AllUsers, Permission.Read);
        uploadZipFile(file, accessControlList);
    }

    @Override
    public Optional<URL> findPublicUrlByAssetId(AssetId assetId) {
        URL url = amazonS3.getUrl("shop-demo", assetId.value());
        return Optional.ofNullable(url);
    }

    private void uploadZipFile(AssetFile file, AccessControlList acl) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.contentType());
        PutObjectRequest request = new PutObjectRequest("shop-demo", file.id().value(), file.inputStream(), metadata)
                .withAccessControlList(acl);
        amazonS3.putObject(request);
    }
}
