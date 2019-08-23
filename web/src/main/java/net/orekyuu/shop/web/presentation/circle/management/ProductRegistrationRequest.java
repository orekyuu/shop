package net.orekyuu.shop.web.presentation.circle.management;

import net.orekyuu.shop.core.domain.model.asset.AssetFile;
import net.orekyuu.shop.core.domain.model.asset.AssetId;
import net.orekyuu.shop.core.domain.model.product.*;
import net.orekyuu.shop.core.domain.type.amount.Amount;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductRegistrationRequest {

    @NotBlank
    String productName;
    @NotBlank
    String description;
    @Future
    @NotNull
    LocalDate release;
    @Min(500)
    @Max(1_000_000)
    @NotNull
    Long price;
    @Size(min = 1, max = 10)
    List<MultipartFile> images;

    ProductName productName() {
        return new ProductName(productName);
    }

    ProductDescription description() {
        return new ProductDescription(description);
    }

    ReleaseDate releaseDate() {
        return new ReleaseDate(release);
    }

    WholesalePrice price() {
        return new WholesalePrice(new Amount(price.intValue()));
    }

    ProductImages images() throws IOException {
        ArrayList<ProductImage> files = new ArrayList<>();
        for (MultipartFile file : this.images) {
            AssetFile f = new AssetFile(file.getBytes(), new AssetId());
            ProductImage image = new ProductImage(f);
            files.add(image);
        }
        return new ProductImages(files);
    }
}
