package net.orekyuu.shop.core.domain.type.amount;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 率（金額にかけられる税率など）
 */
public class Percentage {
    /**
     * 消費税
     */
    public static final Percentage CONSUMPTION_TAX = new Percentage(8);
    final Integer value;

    public Percentage(Integer value) {
        this.value = value;
    }

    public BigDecimal rate() {
        return BigDecimal.valueOf(value).divide(BigDecimal.valueOf(100), 2, RoundingMode.UNNECESSARY);
    }

    @Override
    public String toString() {
        return new DecimalFormat("#,##0'%'").format(rate());
    }
}
