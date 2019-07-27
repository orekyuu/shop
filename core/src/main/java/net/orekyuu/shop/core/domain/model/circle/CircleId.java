package net.orekyuu.shop.core.domain.model.circle;

import java.util.Objects;
import java.util.UUID;

/**
 * サークルID
 */
public class CircleId {
    final String value;

    @Deprecated
    public CircleId(String value) {
        this.value = value;
    }

    public CircleId() {
        this(UUID.randomUUID().toString());
    }

    public String text() {
        return value;
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
