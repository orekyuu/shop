package net.orekyuu.shop.web.application.service.circle;

import net.orekyuu.shop.core.domain.model.circle.*;
import net.orekyuu.shop.identity.domain.model.account.AccountId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CircleService {

    final CircleRepository repository;

    public CircleService(CircleRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CircleId registration(AccountId account, CircleName name, CircleHomePage homePage, CircleSupportMailAddress mailAddress) {
        return repository.registerCircle(account, name, homePage, mailAddress);
    }
}
