package net.orekyuu.shop.web.infrastructure.datasource.product;

import net.orekyuu.shop.core.domain.model.circle.CircleHomePage;
import net.orekyuu.shop.core.domain.model.circle.CircleId;
import net.orekyuu.shop.core.domain.model.circle.CircleName;
import net.orekyuu.shop.core.domain.model.circle.CircleSupportMailAddress;
import net.orekyuu.shop.core.domain.model.product.*;
import net.orekyuu.shop.core.domain.type.amount.Amount;
import net.orekyuu.shop.core.domain.model.asset.AssetId;
import net.orekyuu.shop.identity.domain.model.account.AccountId;
import net.orekyuu.shop.identity.domain.model.account.AccountMailAddress;
import net.orekyuu.shop.identity.domain.model.account.Password;
import net.orekyuu.shop.identity.domain.type.Encrypted;
import net.orekyuu.shop.web.infrastructure.datasource.account.AccountDao;
import net.orekyuu.shop.web.infrastructure.datasource.account.AccountTable;
import net.orekyuu.shop.web.infrastructure.datasource.circle.CircleDao;
import net.orekyuu.shop.web.infrastructure.datasource.circle.CircleTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@SuppressWarnings("deprecation")
@Transactional
class DatabaseProductRepositoryTest {

    @Autowired
    ProductRepository repo;

    @Autowired
    ProductDao dao;
    @Autowired
    AccountDao accountDao;
    @Autowired
    CircleDao circleDao;

    AccountTable accountTable = new AccountTable(
            new AccountId("orekyuu"),
            Encrypted.from(new Password("test"), Password::rawText),
            new AccountMailAddress("orekyuu@example.test"));

    CircleTable circleTable = new CircleTable(
            new CircleId(-1L),
            new CircleName("test circle"),
            new CircleHomePage("https://example.test"),
            new CircleSupportMailAddress("support@example.test"),
            LocalDateTime.now(),
            accountTable.toAccount().id());

    ProductTable product1;
    ProductTable product2;

    @BeforeEach
    void setup() {
        accountDao.insert(accountTable);
        circleTable = circleDao.insert(circleTable).getEntity();

        {
            ProductTable productTable = new ProductTable(
                    new ProductName("book"),
                    new ProductDescription("desc"),
                    circleTable.toCircle().id(),
                    new ReleaseDate(LocalDate.of(2019, 8, 31)),
                    new WholesalePrice(new Amount(1000)),
                    LocalDateTime.now());
            product1 = dao.insertProduct(productTable).getEntity();
            dao.insertImage(product1.createImage(productTable.registeredAt));
            dao.insertImage(product1.createImage(productTable.registeredAt));
        }

        {
            ProductTable productTable = new ProductTable(
                    new ProductName("book"),
                    new ProductDescription("desc"),
                    circleTable.toCircle().id(),
                    new ReleaseDate(LocalDate.of(2019, 8, 31)),
                    new WholesalePrice(new Amount(1000)),
                    LocalDateTime.now());
            product2 = dao.insertProduct(productTable).getEntity();
            dao.insertImage(product2.createImage(productTable.registeredAt));
        }

    }

    @Test
    void サークルで検索() {
        List<Product> result = repo.findByCircle(circleTable.toCircle().id());
        assertThat(result).hasSize(2);
        {
            Product actual = result.stream().filter(it -> it.id().equals(product1.id)).findFirst().get();
            assertThat(actual.images().size()).isEqualTo(2);
        }

        {
            Product actual = result.stream().filter(it -> it.id().equals(product2.id)).findFirst().get();
            assertThat(actual.images().size()).isEqualTo(1);
        }
    }

    @Test
    void 作品登録() {
        ProductId id = repo.registrationProduct(
                circleTable.toCircle().id(),
                new ProductName("hogera"),
                new ProductDescription("registration product test"),
                new ReleaseDate(LocalDate.of(2019, 8, 7)),
                new WholesalePrice(new Amount(1000)),
                new ProductImages(List.of(new ProductImage(new AssetId()), new ProductImage(new AssetId())))
        );

        Product product = repo.findByIds(List.of(id)).get(0);
        assertThat(product.images().size()).isEqualTo(2);
        assertThat(product.name().text()).isEqualTo("hogera");
    }
}
