package net.orekyuu.shop.web.infrastructure.doma;

import net.orekyuu.shop.identity.domain.type.Encrypted;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class EncryptedConverter implements DomainConverter<Encrypted<?>, String> {
    @Override
    public String fromDomainToValue(Encrypted<?> encrypted) {
        return encrypted.toString();
    }

    @SuppressWarnings("deprecation")
    @Override
    public Encrypted<?> fromValueToDomain(String value) {
        if (value == null) {
            return null;
        }
        return new Encrypted<>(value);
    }
}
