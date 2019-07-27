package net.orekyuu.shop.core.domain.model.product;

/**
 * 作品内容
 */
public class ProductDescription {
    final String value;

    public ProductDescription(String value) {
        this.value = value;
    }

    public String text() {
        return value;
    }
}
