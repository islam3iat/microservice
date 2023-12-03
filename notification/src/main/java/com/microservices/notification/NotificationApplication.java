package com.microservices.notification;

import com.microservices.amqp.RabbitMQMessageProducer;
import org.hibernate.annotations.Bag;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication(scanBasePackages ={"com.microservices.notification","com.microservices.amqp"} )
@EnableFeignClients
@PropertySources({@PropertySource("classpath:client-${spring.profiles.active}.properties")})
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class,args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(NotificationConfig notificationConfig, RabbitMQMessageProducer messageProducer){
//        return args -> {
//            messageProducer.publish("foo",notificationConfig.getInternalExchange(),notificationConfig.getInternalNotificationRoutingKey());
//
//
//        };
//    }

}
