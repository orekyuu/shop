package net.orekyuu.shop.web.infrastructure.configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfiguration {
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
