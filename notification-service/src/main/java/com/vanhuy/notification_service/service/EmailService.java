package com.vanhuy.notification_service.service;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailService {
    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public void sendEmail(String toEmail,  String username) {
        try{
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);

            helper.setFrom(from);
            helper.setTo(toEmail);
            helper.setSubject("Welcome to our website");

            // create context
            Context context = new Context();
            context.setVariable("username", username);

            // process template
            String html = templateEngine.process("welcome", context);

            helper.setText(html, true);

            javaMailSender.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void sendForgotPasswordEmail(String toEmail, Map<String, String> templateData) {
        try {
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);

            helper.setFrom(from);
            helper.setTo(toEmail);
            helper.setSubject("Reset your password");

            // create context
            Context context = new Context();
            context.setVariable("resetLink", templateData.get("resetLink"));
            context.setVariable("expirationHours", templateData.get("expirationHours"));

            // process template
            String html = templateEngine.process("forgot-password", context);

            helper.setText(html, true);

            javaMailSender.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
