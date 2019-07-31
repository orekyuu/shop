package net.orekyuu.shop.web.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("login")
@Controller
public class LoginController {

    @GetMapping
    String showLogin() {
        return "login/show";
    }
}
