package net.orekyuu.shop.web.infrastructure.configuration;

import io.lettuce.core.RedisClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfiguration {
    final String url;

    public RedisConfiguration(@Value("${spring.redis.url}") String url) {
        this.url = url;
    }

    @Bean
    RedisClient redisClient() {
        return RedisClient.create(url);
    }
}
