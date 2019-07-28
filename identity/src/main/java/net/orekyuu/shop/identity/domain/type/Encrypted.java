package net.orekyuu.shop.identity.domain.type;

import java.nio.charset.StandardCharsets;
import java.util.function.Function;

/**
 * 暗号化処理済みの文字列を表す型
 * @param <T>
 */
public class Encrypted<T> {
    final byte[] value;

    Encrypted(byte[] value) {
        this.value = value;
    }

    public static <T> Encrypted<T> from(T from, Function<T, byte[]> converter) {
        return new Encrypted<>(converter.apply(from));
    }

    @Override
    public String toString() {
        return new String(value, StandardCharsets.UTF_8);
    }
}
