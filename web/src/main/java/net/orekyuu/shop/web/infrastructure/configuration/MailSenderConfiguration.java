package net.orekyuu.shop.web.infrastructure.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.util.Arrays;

@Configuration
public class MailSenderConfiguration {

    @Profile("!production")
    @Bean
    JavaMailSender mailSender() {
        return new NullMailSender();
    }

    private static class NullMailSender implements JavaMailSender {

        private static final Logger logger = LoggerFactory.getLogger(NullMailSender.class);

        @Override
        public MimeMessage createMimeMessage() {
            return null;
        }

        @Override
        public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
            return null;
        }

        @Override
        public void send(MimeMessage mimeMessage) throws MailException {

        }

        @Override
        public void send(MimeMessage... mimeMessages) throws MailException {

        }

        @Override
        public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {

        }

        @Override
        public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {

        }

        @Override
        public void send(SimpleMailMessage simpleMessage) throws MailException {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            StringBuilder builder = new StringBuilder("Send mail\n");
            builder.append("to     : ").append(Arrays.toString(simpleMessage.getTo())).append("\n");
            builder.append("subject: ").append(simpleMessage.getSubject()).append("\n");
            builder.append("body   : ").append(simpleMessage.getText()).append("\n");
            logger.info(builder.toString());
        }

        @Override
        public void send(SimpleMailMessage... simpleMessages) throws MailException {
            for (SimpleMailMessage message : simpleMessages) {
                send(simpleMessages);
            }
        }
    }
}
