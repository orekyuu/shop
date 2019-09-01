package net.orekyuu.shop.web.presentation.web.floor;

import net.orekyuu.shop.core.domain.model.asset.AssetRepository;
import net.orekyuu.shop.core.domain.model.floor.Floor;
import net.orekyuu.shop.core.domain.model.product.Product;
import net.orekyuu.shop.core.domain.model.product.ProductRepository;
import net.orekyuu.shop.web.presentation.web.FrontInitialData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class FloorController {

    final ProductRepository productRepository;
    final AssetRepository repository;

    public FloorController(ProductRepository productRepository, AssetRepository repository) {
        this.productRepository = productRepository;
        this.repository = repository;
    }

    @GetMapping("home")
    String home(@ModelAttribute("initialData") FrontInitialData frontInitialData) {
        List<Product> newProducts = productRepository.findNewProductByFloor(1, Floor.全年齢向け_同人);
        frontInitialData.addJsonObject("newProducts", newProducts);
        return "floor/home";
    }
}
