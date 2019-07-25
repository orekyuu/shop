package net.orekyuu.shop.core.domain.circle;

import java.util.Objects;

/**
 * サークル名
 */
public class CircleName {
    final String value;

    public CircleName(String value) {
        this.value = value;
    }

    public String text() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircleName that = (CircleName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
