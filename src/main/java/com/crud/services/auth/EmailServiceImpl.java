package com.crud.services.auth;

import com.crud.entity.auth.EmailNotification;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService{

    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(EmailNotification emailNotification) {
        if (emailNotification.isHasTemplate()) {
            sendTemplate(emailNotification);
        }
        sendEmailPlainText(emailNotification);
    }

    public void sendEmailPlainText(EmailNotification emailNotification){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailNotification.getTo());
        mailMessage.setSubject(emailNotification.getSubject());
        mailMessage.setText(emailNotification.getBody());
        javaMailSender.send(mailMessage);
    }

    public void sendTemplate(EmailNotification emailNotification){
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
        try {
            helper.setTo(emailNotification.getTo());
            helper.setSubject(emailNotification.getSubject());
            helper.setText(emailNotification.getBody(), true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        javaMailSender.send(mailMessage);
    }
}
