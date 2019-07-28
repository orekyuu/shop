package net.orekyuu.shop.web.domain.model.mail;

import net.orekyuu.shop.identity.domain.model.account.AccountRegistrationLinkMail;

/**
 * メール送信サービス
 */
public interface MailService {

    void send(AccountRegistrationLinkMail mail);
}
