package net.orekyuu.shop.web.infrastructure.datasource.asset;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import net.orekyuu.shop.core.domain.model.asset.AssetFile;
import net.orekyuu.shop.core.domain.model.asset.AssetRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class AssetRepositoryImpl implements AssetRepository {
    final AmazonS3 amazonS3;

    public AssetRepositoryImpl(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    @Override
    public void save(Iterable<AssetFile> files) {
        files.forEach(f -> {
            UploadPartRequest request = new UploadPartRequest()
                    .withInputStream(f.inputStream())
                    .withUploadId(f.id().value())
                    .withBucketName("ShopDemo")
                    .withSdkRequestTimeout((int) TimeUnit.SECONDS.toMinutes(1));
            amazonS3.uploadPart(request);
        });
    }
}
