package net.orekyuu.shop.web.infrastructure.datasource.circle;

import net.orekyuu.shop.core.domain.model.circle.Circle;
import net.orekyuu.shop.core.domain.model.circle.CircleId;
import net.orekyuu.shop.core.domain.model.circle.CircleName;
import net.orekyuu.shop.identity.domain.model.account.AccountId;
import org.seasar.doma.*;

import java.time.LocalDateTime;

@Entity(immutable = true)
@Table(name = "circles")
public class CircleTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    final CircleId id;
    @Column
    final CircleName name;
    @Column
    final LocalDateTime registeredAt;
    @Column
    final AccountId accountId;

    public CircleTable(CircleId id, CircleName name, LocalDateTime registeredAt, AccountId accountId) {
        this.id = id;
        this.name = name;
        this.registeredAt = registeredAt;
        this.accountId = accountId;
    }

    public Circle toCircle() {
        return new Circle(id, name);
    }
}
