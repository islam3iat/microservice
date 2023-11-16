package com.microservices.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.microservices.client.MailDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
@Slf4j
public class MailController {
    private final NotificationService notificationService;
    @PostMapping
    public void sendEmail(@RequestBody MailDto mail){
        log.info("send message {}",mail);
         notificationService.sendEmail(mail);
    }
}
