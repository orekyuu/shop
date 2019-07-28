package net.orekyuu.shop.web.infrastructure.datasource.account;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.sync.RedisCommands;
import net.orekyuu.shop.identity.domain.model.account.AccountMailAddress;
import net.orekyuu.shop.identity.domain.model.account.AccountRegistrationToken;
import net.orekyuu.shop.identity.domain.model.account.AccountRegistrationTokenStore;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class RedisRegistrationMailTokenStore implements AccountRegistrationTokenStore {
    final RedisClient client;

    public RedisRegistrationMailTokenStore(RedisClient client) {
        this.client = client;
    }

    @Override
    public void save(AccountRegistrationToken token) {
        try(var connection = this.client.connect()) {
            long seconds = Duration.between(LocalDateTime.now(), token.expiredAt()).getSeconds();
            connection.sync().setex(redisKey(token.token()), seconds, token.address().value());
        }
    }

    @Override
    public Optional<AccountRegistrationToken> consume(String token) {
        try(var connection = this.client.connect()) {
            String key = redisKey(token);
            RedisCommands<String, String> commands = connection.sync();

            String mailAddress = commands.get(key);
            commands.del(key);

            return Optional.ofNullable(mailAddress)
                    .map(AccountMailAddress::new)
                    .map(it -> new AccountRegistrationToken(LocalDateTime.now(), it));
        }
    }

    @Override
    public Optional<AccountRegistrationToken> find(String token) {
        try(var connection = this.client.connect()) {
            String mailAddress = connection.sync().get(redisKey(token));
            return Optional.ofNullable(mailAddress)
                    .map(AccountMailAddress::new)
                    .map(it -> new AccountRegistrationToken(LocalDateTime.now(), it));
        }
    }

    private String redisKey(String token) {
        return "account_registration_email:" + token;
    }
}
