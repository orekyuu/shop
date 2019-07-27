package net.orekyuu.shop.core.domain.model.product;

/**
 * 作品名
 */
public class ProductName {
    final String name;

    public ProductName(String name) {
        this.name = name;
    }

    public String text() {
        return name;
    }
}
