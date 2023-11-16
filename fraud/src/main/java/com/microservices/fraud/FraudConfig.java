package com.microservices.fraud;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration

public class FraudConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;
    @Value("${rabbitmq.queues.fraud}")
    private String fraudQueue;
    @Value("${rabbitmq.routing-keys.internal}")
    private String internalFraudRoutingKey;
//    @Bean
//    public TopicExchange internalTopicExchange(){
//        return new TopicExchange(this.internalExchange);
//    }
//    @Bean
//    public Queue notificationQueue(){
//        return new Queue(this.fraudQueue);
//    }
//    @Bean
//    public Binding internalNotificationRoutingKey(){
//        return BindingBuilder.bind(notificationQueue()).
//                to(internalTopicExchange()).
//                with(this.internalFraudRoutingKey);
//    }
    public String getInternalExchange() {
        return internalExchange;
    }
    public String getFraudQueue() {
        return fraudQueue;
    }
    public String getInternalFraudRoutingKey() {
        return internalFraudRoutingKey;
    }
}
