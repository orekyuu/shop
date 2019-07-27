package net.orekyuu.shop.identity.domain.type;

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
}
