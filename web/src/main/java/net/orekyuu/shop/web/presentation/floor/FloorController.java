package net.orekyuu.shop.web.presentation.floor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class FloorController {

    @GetMapping("home")
    String home() {
        return "floor/home";
    }
}
