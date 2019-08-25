package net.orekyuu.shop.web.presentation.circle.management;

import net.orekyuu.shop.core.domain.model.asset.AssetFile;
import net.orekyuu.shop.core.domain.model.asset.AssetRepository;
import net.orekyuu.shop.core.domain.model.circle.Circle;
import net.orekyuu.shop.core.domain.model.product.ProductImage;
import net.orekyuu.shop.core.domain.model.product.ProductImages;
import net.orekyuu.shop.core.domain.model.product.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("circle/products/registration")
public class ProductRegistrationController {

    final ProductRepository repository;
    final AssetRepository assetRepository;

    public ProductRegistrationController(ProductRepository repository, AssetRepository assetRepository) {
        this.repository = repository;
        this.assetRepository = assetRepository;
    }

    @ModelAttribute
    ProductRegistrationRequest productRegistrationRequest() {
        return new ProductRegistrationRequest();
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
            List<AssetFile> files = form.files();
            List<ProductImage> images = files.stream()
                    .map(AssetFile::id)
                    .map(ProductImage::new)
                    .collect(Collectors.toList());

            assetRepository.uploadPublicImageFile(files);
            repository.registrationProduct(circle.id(), form.productName(), form.description(), form.releaseDate(), form.price(), new ProductImages(images));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return "redirect:/home";
    }
}
