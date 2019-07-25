package net.orekyuu.shop.core.domain.product;

import net.orekyuu.shop.core.domain.circle.CircleId;

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

    public Product(ProductId id, ProductName name, ProductDescription description, CircleId circle, ReleaseDate release, ProductBasePrice price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.circle = circle;
        this.release = release;
        this.price = price;
    }
}
