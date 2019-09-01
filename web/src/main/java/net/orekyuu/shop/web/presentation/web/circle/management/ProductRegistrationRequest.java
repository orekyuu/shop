package net.orekyuu.shop.web.presentation.web.circle.management;

import net.orekyuu.shop.core.domain.model.asset.AssetFile;
import net.orekyuu.shop.core.domain.model.asset.AssetId;
import net.orekyuu.shop.core.domain.model.product.ProductDescription;
import net.orekyuu.shop.core.domain.model.product.ProductName;
import net.orekyuu.shop.core.domain.model.product.ReleaseDate;
import net.orekyuu.shop.core.domain.model.product.WholesalePrice;
import net.orekyuu.shop.core.domain.type.amount.Amount;
import org.springframework.format.annotation.DateTimeFormat;
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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate release;
    @Min(500)
    @Max(1_000_000)
    @NotNull
    Long price;
    @Size(min = 1, max = 10)
    MultipartFile[] images = new MultipartFile[1];

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

    List<AssetFile> files() throws IOException {
        ArrayList<AssetFile> files = new ArrayList<>();
        for (MultipartFile file : this.images) {
            if (file == null) {
                continue;
            }
            files.add(new AssetFile(file.getBytes(), AssetId.fromFileName(file.getOriginalFilename()), file.getContentType()));
        }
        return files;
    }
}
