package net.orekyuu.shop.web.presentation.web.account;

import net.orekyuu.shop.identity.domain.model.account.AccountMailAddress;
import net.orekyuu.shop.web.application.repository.account.AccountRegistrationService;
import net.orekyuu.shop.web.application.repository.account.InvalidMailTokenException;
import net.orekyuu.shop.web.presentation.json.FormAndValidation;
import net.orekyuu.shop.web.presentation.web.FrontInitialData;
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
        return new AccountRegistrationForm();
    }

    @ModelAttribute
    SendMailForm sendMailForm() {
        return new SendMailForm();
    }

    @GetMapping("registration/mail")
    public String showRegistration(
            @ModelAttribute SendMailForm form,
            @ModelAttribute("initialData") FrontInitialData frontInitialData) {
        frontInitialData.addJsonObject("mailForm", new FormAndValidation<>(form));
        return "accounts/registration";
    }

    @PostMapping("registration/mail")
    public String sendRegistrationMail(
            @Validated @ModelAttribute SendMailForm form, BindingResult result,
            @ModelAttribute("initialData") FrontInitialData frontInitialData) {

        frontInitialData.addJsonObject("mailForm", new FormAndValidation<>(form, result));
        if (result.hasErrors()) {
            return "accounts/registration";
        }

        registrationService.sendRegistrationLinkMail(new AccountMailAddress(form.mail));
        return "redirect:/accounts/registration/mail?complete";
    }

    @GetMapping("registration")
    public String showRegistrationProfile(
            @RequestParam(value = "token") String token,
            @ModelAttribute AccountRegistrationForm form,
            @ModelAttribute("initialData") FrontInitialData frontInitialData) {
        frontInitialData.addJsonObject("registrationForm", new FormAndValidation<>(form));

        registrationService.findByToken(token).orElseThrow(InvalidMailTokenException::new);
        form.token = token;
        return "accounts/registration";
    }

    @PostMapping("registration")
    public String registrationProfile(
            @ModelAttribute("initialData") FrontInitialData frontInitialData,
            @Validated @ModelAttribute AccountRegistrationForm form, BindingResult result) {
        if (result.hasErrors()) {
            frontInitialData.addJsonObject("registrationForm", new FormAndValidation<>(form, result));
            return "accounts/registration";
        }
        registrationService.registration(form.accountId(), form.password(), form.token);
        return "redirect:/";
    }

    @GetMapping("registration/invalid_token")
    public String showInvalidTokenError() {
        return "accounts/registration";
    }

    @ExceptionHandler(InvalidMailTokenException.class)
    public String handleInvalidTokenError() {
        return "redirect:/accounts/registration/invalid_token";
    }
}
