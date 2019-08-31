package net.orekyuu.shop.web.presentation.api.web;

import net.orekyuu.shop.web.infrastructure.i18n.ExposedResourceMessageBundleSource;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("web/api/messages")
public class MessageResourceController {

    final ExposedResourceMessageBundleSource messageSource;

    public MessageResourceController(ExposedResourceMessageBundleSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    Map<String, String> messages(Locale locale) {
        return messageSource.getMessages(locale).entrySet().stream()
                .collect(Collectors.toMap(it -> (String)it.getKey(), it -> (String)it.getValue()));
    }
}
