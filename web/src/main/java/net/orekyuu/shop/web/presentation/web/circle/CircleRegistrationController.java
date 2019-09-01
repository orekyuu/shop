package net.orekyuu.shop.web.presentation.web.circle;

import net.orekyuu.shop.web.application.service.circle.CircleService;
import net.orekyuu.shop.web.infrastructure.security.ShopUserDetails;
import net.orekyuu.shop.web.presentation.json.FormAndValidation;
import net.orekyuu.shop.web.presentation.web.Authenticated;
import net.orekyuu.shop.web.presentation.web.FrontInitialData;
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
    public String show(@ModelAttribute("initialData") FrontInitialData frontInitialData,
                       @ModelAttribute CircleRegistrationForm form) {
        frontInitialData.addJsonObject("circleRegistrationForm", new FormAndValidation<>(form));
        return "circle/registration/show";
    }

    @GetMapping("complete")
    public String complete() {
        return "circle/registration/show";
    }

    @PostMapping
    public String registration(
            @ModelAttribute("initialData") FrontInitialData frontInitialData,
            @Validated @ModelAttribute CircleRegistrationForm form, BindingResult result,
            @AuthenticationPrincipal ShopUserDetails user) {
        if (result.hasErrors()) {
            frontInitialData.addJsonObject("circleRegistrationForm", new FormAndValidation<>(form, result));
            return "circle/registration/show";
        }

        service.registration(user.accountId(), form.circleName(), form.homePage(), form.supportMailAddress());

        return "redirect:/circle/registration/complete";
    }
}
