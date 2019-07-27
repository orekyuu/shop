package net.orekyuu.shop.core.domain.type.amount;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 金額
 */
public class Amount implements Comparable<Amount> {

    final BigDecimal value;

    public Amount(BigDecimal value) {
        this.value = value;
    }

    public Amount(Integer value) {
        this(BigDecimal.valueOf(value));
    }

    public Amount add(Amount other) {
        return new Amount(value.add(other.value));
    }

    public Amount minus(Amount other) {
        return new Amount(value.subtract(other.value));
    }

    public Amount multiply(Percentage rate, RoundingMode roundingMode) {
        return new Amount(value.multiply(rate.rate()).setScale(value.scale(), roundingMode.value));
    }

    @Override
    public int compareTo(Amount o) {
        return value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return new DecimalFormat("#,##0'円'").format(value.intValue());
    }

    public BigDecimal value() {
        return value;
    }
}
