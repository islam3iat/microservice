package com.microservices.notification;

import com.microservices.client.MailDto;

public class MailUtils {
    public static Mail dtoToEntity(MailDto dto){
        Mail mail=new Mail();
        mail.setTo(dto.to());
        mail.setSubject(dto.subject());
        mail.setText(dto.text());
        mail.setCustomerId(dto.customerId());
        return mail;
    }
}
