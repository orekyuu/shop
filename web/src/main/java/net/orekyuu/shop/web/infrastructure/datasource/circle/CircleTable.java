package net.orekyuu.shop.web.infrastructure.datasource.circle;

import net.orekyuu.shop.core.domain.model.circle.*;
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
    final CircleHomePage homePage;
    @Column(name = "support_mail")
    final CircleSupportMailAddress mailAddress;
    @Column
    final LocalDateTime registeredAt;
    @Column
    final AccountId accountId;

    public CircleTable(CircleId id, CircleName name, CircleHomePage homePage, CircleSupportMailAddress mailAddress, LocalDateTime registeredAt, AccountId accountId) {
        this.id = id;
        this.name = name;
        this.homePage = homePage;
        this.mailAddress = mailAddress;
        this.registeredAt = registeredAt;
        this.accountId = accountId;
    }

    public Circle toCircle() {
        return new Circle(id, name, mailAddress, homePage);
    }
}
