package net.orekyuu.shop.web.presentation.circle.management;

import net.orekyuu.shop.core.domain.model.circle.Circle;
import net.orekyuu.shop.core.domain.model.circle.CircleRepository;
import net.orekyuu.shop.web.infrastructure.security.ShopUserDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@ControllerAdvice(basePackageClasses = CircleManagementControllerAdvice.class)
public class CircleManagementControllerAdvice {
    final CircleRepository circleRepository;

    static final String CIRCLE_KEY = "current_circle";

    public CircleManagementControllerAdvice(CircleRepository circleRepository) {
        this.circleRepository = circleRepository;
    }

    @ModelAttribute(CIRCLE_KEY)
    Circle circle(@AuthenticationPrincipal ShopUserDetails user) {
        return Optional.ofNullable(user)
                .map(ShopUserDetails::accountId)
                .flatMap(id ->
                        circleRepository.findByAccount(user.accountId())
                )
                .orElseThrow(() -> HttpClientErrorException.create(HttpStatus.FORBIDDEN, "", HttpHeaders.EMPTY, null, null));
    }
}
