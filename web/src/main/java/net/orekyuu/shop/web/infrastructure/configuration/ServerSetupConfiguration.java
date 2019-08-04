package net.orekyuu.shop.web.infrastructure.configuration;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class ServerSetupConfiguration {
    final AmazonS3 storage;

    public ServerSetupConfiguration(AmazonS3 storage) {
        this.storage = storage;
    }

    @PostConstruct
    void setup() {
        List<Bucket> bucketList = storage.listBuckets();
        if (bucketList.stream().noneMatch(bucket -> bucket.getName().equals("shop-demo"))) {
            storage.createBucket("shop-demo");
        }
    }
}
