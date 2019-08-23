package net.orekyuu.shop.web.infrastructure.util;

import net.orekyuu.shop.core.domain.model.product.Product;
import net.orekyuu.shop.web.infrastructure.datasource.product.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Collector2 {
    private Collector2() {}

    /**
     * Entityを指定のキーで集約したDomainオブジェクトのリスト
     * @param identity　キー
     * @param entity2domain　Entity -> Domainへの変換
     * @param merger 複数のEntityをマージする
     * @param <ENTITY> 変換前の値
     * @param <DOMAIN> 変換後のドメインオブジェクト
     * @return Entity -> List<Domain>への変換をするCollector
     */
    public static <ENTITY, DOMAIN> Collector<ENTITY, ?, List<DOMAIN>> mapping(
            Function<ENTITY, ?> identity,
            Function<ENTITY, DOMAIN> entity2domain,
            BinaryOperator<DOMAIN> merger) {
        return Collectors.collectingAndThen(
                Collectors.toMap(identity, entity2domain, merger),
                map -> new ArrayList<>(map.values())
        );
    }

    public static <T> Collector<T, ?, Optional<T>> toOptional() {
        return Collector.<T, AtomicReference<T>, Optional<T>>of(
                AtomicReference::new,
                (acc, t) -> acc.compareAndSet(null, t),
                (a, b)   -> {a.compareAndSet(null, b.get()); return a;},
                acc      -> Optional.ofNullable(acc.get()),
                Collector.Characteristics.CONCURRENT
        );
    }
}
