package com.microservices.notification.rabbitmq;

import com.microservices.client.MailDto;
import com.microservices.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService notificationService;
    @RabbitListener(queues ="${rabbitmq.queues.notification}" )
    public void consumer(MailDto request){
        log.info("Consumed {} form queue",request);
        notificationService.sendEmail(request);
    }
}
