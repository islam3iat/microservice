package com.microservices.notification;

import lombok.RequiredArgsConstructor;
import com.microservices.client.MailDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender javaMailSender;
    private final MailRepository mailRepository;
    public void sendEmail(MailDto mail){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(mail.to());
        message.setSubject(mail.subject());
        message.setText(mail.text());
//        javaMailSender.send(message);
        mailRepository.save(MailUtils.dtoToEntity(mail));
    }


}
