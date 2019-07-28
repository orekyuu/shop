package net.orekyuu.shop.identity.domain.type;

import java.nio.charset.StandardCharsets;

/**
 * 暗号化処理済みの文字列を表す型
 * @param <T>
 */
public class Encrypted<T> {
    final byte[] value;

    private Encrypted(byte[] value) {
        this.value = value;
    }

    public static <T extends Encryptable> Encrypted<T> from(T from) {
        return new Encrypted<>(from.encrypt());
    }

    @Override
    public String toString() {
        return new String(value, StandardCharsets.UTF_8);
    }
}
