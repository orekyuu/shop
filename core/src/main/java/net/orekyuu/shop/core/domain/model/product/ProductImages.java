package net.orekyuu.shop.core.domain.model.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ProductImages {
    final List<ProductImage> value;

    public ProductImages(List<ProductImage> value) {
        this.value = new ArrayList<>(value);
    }

    public int size() {
        return value.size();
    }

    public ProductImages plus(ProductImage image) {
        value.add(image);
        return new ProductImages(value);
    }

    public ProductImages plus(ProductImages images) {
        value.addAll(images.value);
        return new ProductImages(value);
    }

    public Stream<ProductImage> stream() {
        return value.stream();
    }
}
