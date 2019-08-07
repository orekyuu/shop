package net.orekyuu.shop.core.domain.model.product;

import net.orekyuu.shop.core.domain.model.circle.CircleId;

/**
 * 作品
 */
public class Product {
    final ProductId id;
    final ProductName name;
    final ProductDescription description;
    final CircleId circle;
    final ReleaseDate release;
    final ProductBasePrice price;
    ProductImages productImages;

    public Product(ProductId id, ProductName name, ProductDescription description, CircleId circle, ReleaseDate release, ProductBasePrice price, ProductImages productImages) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.circle = circle;
        this.release = release;
        this.price = price;
        this.productImages = productImages;
    }

    public ProductId id() {
        return id;
    }

    public ProductImages images() {
        return productImages;
    }

    public void addImage(ProductImage image) {
        productImages = productImages.plus(image);
    }

    public void addImage(ProductImages images) {
        productImages = productImages.plus(images);
    }

    public ProductName name() {
        return name;
    }
}
