package com.microservices.customer;

import com.microservices.amqp.RabbitMQMessageProducer;
import lombok.AllArgsConstructor;
import com.microservices.client.FraudCheckResponse;
import com.microservices.client.FraudClient;
import com.microservices.client.MailDto;
import com.microservices.client.NotificationClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RabbitMQMessageProducer messageProducer;
    private final FraudClient fraudClient;


    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        // todo: send notification
        MailDto mail = new MailDto(customer.getEmail(), "ee", null, customer.getId());
        messageProducer.publish(mail,"internal.exchange","internal.notification.routing-key");

    }
}
