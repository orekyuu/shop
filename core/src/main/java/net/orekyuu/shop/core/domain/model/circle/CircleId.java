package net.orekyuu.shop.core.domain.model.circle;

import java.util.Objects;
import java.util.UUID;

/**
 * サークルID
 */
public class CircleId {
    final Long value;

    @Deprecated
    public CircleId(Long value) {
        this.value = value;
    }

    public Long value() {
        return value;
    }

    public String text() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircleId circleId = (CircleId) o;
        return value.equals(circleId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
