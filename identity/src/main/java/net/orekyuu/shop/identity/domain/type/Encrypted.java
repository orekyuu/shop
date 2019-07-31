package net.orekyuu.shop.identity.domain.type;

import java.util.function.Function;

/**
 * 暗号化処理済みの文字列を表す型
 * @param <T>
 */
public class Encrypted<T> {
    final String value;

    @Deprecated
    public Encrypted(String value) {
        this.value = value;
    }

    public static <T> Encrypted<T> from(T from, Function<T, String> converter) {
        String value = converter.apply(from);
        return new Encrypted<>(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
