package net.orekyuu.shop.web.infrastructure.mail;

import net.orekyuu.shop.identity.domain.model.account.AccountRegistrationLinkMail;
import net.orekyuu.shop.identity.domain.model.mail.MailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImpl implements MailService {
    final JavaMailSender sender;

    public MailServiceImpl(JavaMailSender sender) {
        this.sender = sender;
    }

    @Override
    @Async
    public void send(AccountRegistrationLinkMail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(mail.title());
        message.setText(mail.body());
        message.setTo(mail.address());
        sender.send(message);
    }
}
