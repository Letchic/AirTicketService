package com.letchic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service("emailService")
public class EmailService {
    @Autowired
    public JavaMailSender mailSender;

    public void sendPreConfiguredMail(String to, String message) {
        System.out.println("sendPreConfiguredMail");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setFrom("airlineticketservice@gmail.com");
        mailMessage.setSubject("Air Ticket");
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
