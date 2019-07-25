package net.orekyuu.shop.core.domain.product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 発売開始日
 */
public class ReleaseDate implements Comparable<ReleaseDate> {
    final LocalDate value;

    public ReleaseDate(LocalDate value) {
        this.value = value;
    }

    public String text() {
        return value.format(DateTimeFormatter.ofPattern("uuuu年MM月dd日"));
    }

    public boolean isReleased() {
        return value.atStartOfDay().isAfter(LocalDateTime.now());
    }

    @Override
    public int compareTo(ReleaseDate o) {
        return value.compareTo(o.value);
    }
}
