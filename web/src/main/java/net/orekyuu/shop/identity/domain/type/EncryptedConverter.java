package net.orekyuu.shop.identity.domain.type;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

import java.nio.charset.StandardCharsets;

@ExternalDomain
public class EncryptedConverter implements DomainConverter<Encrypted<?>, String> {
    @Override
    public String fromDomainToValue(Encrypted<?> encrypted) {
        return encrypted.toString();
    }

    @Override
    public Encrypted<?> fromValueToDomain(String value) {
        if (value == null) {
            return null;
        }
        return new Encrypted<>(value.getBytes(StandardCharsets.UTF_8));
    }
}
