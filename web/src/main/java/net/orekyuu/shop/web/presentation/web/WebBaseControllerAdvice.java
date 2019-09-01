package net.orekyuu.shop.web.presentation.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.orekyuu.shop.web.infrastructure.security.ShopUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(basePackageClasses = WebBaseControllerAdvice.class)
public class WebBaseControllerAdvice {
    private final ObjectMapper mapper;

    public WebBaseControllerAdvice(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @ModelAttribute("initialData")
    FrontInitialData frontInitialData(@AuthenticationPrincipal ShopUserDetails user) {
        return new FrontInitialData(user, mapper);
    }
}
