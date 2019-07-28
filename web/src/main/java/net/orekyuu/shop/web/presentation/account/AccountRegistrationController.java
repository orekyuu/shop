package net.orekyuu.shop.web.presentation.account;

import net.orekyuu.shop.identity.domain.model.account.AccountId;
import net.orekyuu.shop.identity.domain.model.account.AccountMailAddress;
import net.orekyuu.shop.identity.domain.model.account.Password;
import net.orekyuu.shop.web.application.repository.account.AccountRegistrationService;
import net.orekyuu.shop.web.application.repository.account.InvalidMailTokenException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("accounts")
public class AccountRegistrationController {

    final AccountRegistrationService registrationService;

    public AccountRegistrationController(AccountRegistrationService registrationService) {
        this.registrationService = registrationService;
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
    public String registrationProfile(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password_confirm") String passwordConfirm,
            @RequestParam("token") String token,
            Model model) {
        //TODO: バリバリのバリデーション
        registrationService.registration(new AccountId(username), new Password(password), token);
        return "redirect:/";
    }

    @ExceptionHandler(InvalidMailTokenException.class)
    public String showInvalidTokenError() {
        return "accounts/token_error";
    }
}
