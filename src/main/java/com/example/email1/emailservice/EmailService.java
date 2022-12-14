package com.example.email1.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTo(String email, String title, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("////////////////");
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }
}
