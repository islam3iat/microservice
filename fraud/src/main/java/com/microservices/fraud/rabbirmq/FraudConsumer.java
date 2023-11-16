package com.microservices.fraud.rabbirmq;

import com.microservices.fraud.FraudCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class FraudConsumer {
    private final FraudCheckService fraudCheckService;
//    @RabbitListener(queues = "${rabbitmq.queues.fraud}")
//    public void consumerFraud(Integer customerId){
//        log.info("Consumed {} from queue",customerId);
//        fraudCheckService.isFraudulentCustomer(customerId);
//    }
}
