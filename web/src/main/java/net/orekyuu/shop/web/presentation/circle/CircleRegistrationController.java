package net.orekyuu.shop.web.presentation.circle;

import net.orekyuu.shop.web.application.service.circle.CircleService;
import net.orekyuu.shop.web.infrastructure.security.ShopUserDetails;
import net.orekyuu.shop.web.presentation.Authenticated;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("circle/registration")
@Authenticated
public class CircleRegistrationController {

    final CircleService service;

    public CircleRegistrationController(CircleService service) {
        this.service = service;
    }

    @ModelAttribute
    CircleRegistrationForm circleRegistrationForm() {
        return new CircleRegistrationForm();
    }

    @GetMapping
    public String show() {
        return "circle/registration/show";
    }

    @PostMapping
    public String registration(@Validated @ModelAttribute CircleRegistrationForm form, BindingResult result, @AuthenticationPrincipal ShopUserDetails user) {
        if (result.hasErrors()) {
            return "circle/registration/show";
        }

        service.registration(user.accountId(), form.circleName(), form.homePage(), form.supportMailAddress());

        return "circle/registration/complete";
    }
}
