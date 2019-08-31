package net.orekyuu.shop.web.infrastructure.i18n;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;
import java.util.Properties;

public class ExposedResourceMessageBundleSource extends ReloadableResourceBundleMessageSource {

    public Properties getMessages(Locale locale){
        return getMergedProperties(locale).getProperties();
    }
}
