package net.orekyuu.shop.web.infrastructure.doma;

import org.seasar.doma.jdbc.domain.DomainConverter;

import java.util.function.Function;

abstract class DomainConverterAdapter<T, V> implements DomainConverter<T, V> {

    final Function<T, V> fromDomain;
    final Function<V, T> fromValue;

    public DomainConverterAdapter(Function<T, V> fromDomain, Function<V, T> fromValue) {
        this.fromDomain = fromDomain;
        this.fromValue = fromValue;
    }

    @Override
    public V fromDomainToValue(T t) {
        if (t == null) {
            return null;
        }
        return fromDomain.apply(t);
    }

    @Override
    public T fromValueToDomain(V value) {
        if (value == null) {
            return null;
        }
        return fromValue.apply(value);
    }
}
