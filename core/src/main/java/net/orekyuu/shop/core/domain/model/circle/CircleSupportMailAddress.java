package net.orekyuu.shop.core.domain.model.circle;

public class CircleSupportMailAddress {
    final String value;

    public CircleSupportMailAddress(String value) {
        this.value = value;
    }

    public String text() {
        return value;
    }
}
