package net.orekyuu.shop.core.domain.model.circle;

/**
 * サークル
 */
public class Circle {
    final CircleId id;
    final CircleName name;
    final CircleSupportMailAddress mailAddress;
    final CircleHomePage homePage;

    public Circle(CircleId id, CircleName name, CircleSupportMailAddress mailAddress, CircleHomePage homePage) {
        this.id = id;
        this.name = name;
        this.mailAddress = mailAddress;
        this.homePage = homePage;
    }

    public CircleId id() {
        return id;
    }

    public CircleName circleName() {
        return name;
    }
}
