package net.orekyuu.shop.web.presentation.web.account;

import net.orekyuu.shop.identity.domain.model.account.AccountMailAddress;
import net.orekyuu.shop.web.application.repository.account.AccountRegistrationService;
import net.orekyuu.shop.web.application.repository.account.InvalidMailTokenException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("accounts")
public class AccountRegistrationController {

    final AccountRegistrationService registrationService;

    public AccountRegistrationController(AccountRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @ModelAttribute("accountRegistrationForm")
    AccountRegistrationForm accountRegistrationForm() {
        AccountRegistrationForm accountRegistrationForm = new AccountRegistrationForm();
        return accountRegistrationForm;
    }

    @GetMapping("registration/mail")
    public String showRegistration() {
        return "accounts/registration";
    }

    @PostMapping("registration/mail")
    public String sendRegistrationMail(@RequestParam("mail") String mail) {
        registrationService.sendRegistrationLinkMail(new AccountMailAddress(mail));
        return "accounts/registration_mail";
    }

    @GetMapping("registration")
    public String showRegistrationProfile(@RequestParam("token") String token, Model model) {
        AccountMailAddress address = registrationService.findByToken(token).orElseThrow(InvalidMailTokenException::new);
        model.addAttribute("mail", address.value());
        model.addAttribute("token", token);
        return "accounts/registration_profile";
    }

    @PostMapping("registration")
    public String registrationProfile(@Validated @ModelAttribute("accountRegistrationForm") AccountRegistrationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "accounts/registration_profile";
        }
        registrationService.registration(form.accountId(), form.password(), form.token);
        return "redirect:/";
    }

    @ExceptionHandler(InvalidMailTokenException.class)
    public String showInvalidTokenError() {
        return "accounts/token_error";
    }
}
