package net.orekyuu.shop.web.presentation.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("accounts")
public class AccountRegistrationController {

    @GetMapping("registration")
    public String showRegistration() {
        return "accounts/registration";
    }
}
