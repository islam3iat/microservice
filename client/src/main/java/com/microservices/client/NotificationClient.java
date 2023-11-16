package com.microservices.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notification",path = "/api/v1/notification")
public interface NotificationClient {
    @PostMapping
    void sendMail(@RequestBody MailDto mail );
}
