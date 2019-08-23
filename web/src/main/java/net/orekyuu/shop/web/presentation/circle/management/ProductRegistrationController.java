package net.orekyuu.shop.web.presentation.circle.management;

import net.orekyuu.shop.core.domain.model.circle.Circle;
import net.orekyuu.shop.core.domain.model.product.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UncheckedIOException;

@Controller
@RequestMapping("circle/products/registration")
public class ProductRegistrationController {

    final ProductRepository repository;

    public ProductRegistrationController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String show(@ModelAttribute(CircleManagementControllerAdvice.CIRCLE_KEY) Circle circle) {
        return "circle/products/registration";
    }

    @PostMapping
    public String registration(@ModelAttribute(CircleManagementControllerAdvice.CIRCLE_KEY) Circle circle,
                               @Validated @ModelAttribute ProductRegistrationRequest form, BindingResult result) {
        if (result.hasErrors()) {
            return "circle/products/registration";
        }

        try {
            repository.registrationProduct(circle.id(), form.productName(), form.description(), form.releaseDate(), form.price(), form.images());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return "redirect:/home";
    }
}
