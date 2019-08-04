package net.orekyuu.shop.web.infrastructure.configuration;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import static org.mockito.Mockito.mock;

@Configuration
public class MockAmazonS3Configuration {

    @Bean
    @Primary
    AmazonS3 mockAmazonS3() {
        return mock(AmazonS3.class);
    }
}
