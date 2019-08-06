package net.orekyuu.shop.core.domain.model.circle;

/**
 * サークル
 */
public class Circle {
    final CircleId id;
    final CircleName name;

    public Circle(CircleId id, CircleName name) {
        this.id = id;
        this.name = name;
    }

    public CircleId id() {
        return id;
    }
}
