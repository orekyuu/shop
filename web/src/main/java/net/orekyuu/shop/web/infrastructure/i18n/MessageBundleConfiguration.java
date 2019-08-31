package net.orekyuu.shop.web.infrastructure.i18n;

import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.time.Duration;

@Configuration
public class MessageBundleConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.messages")
    public MessageSourceProperties messageSourceProperties() {
        return new MessageSourceProperties();
    }

    @Bean("messageSource")
    public ExposedResourceMessageBundleSource messageSource(MessageSourceProperties properties) {
        ExposedResourceMessageBundleSource source = new ExposedResourceMessageBundleSource();
        if (StringUtils.hasText(properties.getBasename())) {
            source.setBasenames(StringUtils
                    .commaDelimitedListToStringArray(StringUtils.trimAllWhitespace(properties.getBasename())));
        }
        if (properties.getEncoding() != null) {
            source.setDefaultEncoding(properties.getEncoding().name());
        }
        source.setFallbackToSystemLocale(properties.isFallbackToSystemLocale());
        Duration cacheDuration = properties.getCacheDuration();
        if (cacheDuration != null) {
            source.setCacheMillis(cacheDuration.toMillis());
        }
        source.setAlwaysUseMessageFormat(properties.isAlwaysUseMessageFormat());
        source.setUseCodeAsDefaultMessage(properties.isUseCodeAsDefaultMessage());
        return source;
    }
}
