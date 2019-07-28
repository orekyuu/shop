package net.orekyuu.shop.web.presentation.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("accounts")
public class AccountRegistrationController {

    @GetMapping("registration")
    public String showRegistration() {
        return "accounts/registration";
    }

    @PostMapping("registration/mail")
    public String sendRegistrationMail(@RequestParam("mail") String mail) {
        return "accounts/registration_mail";
    }
}
