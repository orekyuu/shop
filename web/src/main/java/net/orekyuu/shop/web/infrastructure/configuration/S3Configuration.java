package net.orekyuu.shop.web.infrastructure.configuration;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class S3Configuration {
    final String url;
    final String accessKey;
    final String secretKey;

    public S3Configuration(@Value("${storage.url}") String url,
                           @Value("${cloud.aws.credentials.access-key}") String accessKey,
                           @Value("${cloud.aws.credentials.secret-key}") String secretKey) {
        this.url = url;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @PostConstruct
    void setup() {
        AmazonS3 amazonS3 = amazonS3();
        List<Bucket> bucketList = amazonS3.listBuckets();
        if (bucketList.stream().noneMatch(bucket -> bucket.getName().equals("shop-demo"))) {
            amazonS3.createBucket("shop-demo");
        }
    }

    @Bean
    AmazonS3 amazonS3() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setProtocol(Protocol.HTTP);


        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(url, null))
                .withClientConfiguration(clientConfig)
                .withPathStyleAccessEnabled(true)
                .build();
    }
}
