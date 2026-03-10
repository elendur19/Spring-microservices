package com.robic.amqp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMqMessageProducer {

    private final AmqpTemplate amqpTemplate;

    /*
    Publish to exchange with the routing key
    payload of type "Object" in order to use any
    object type
     */
    public void publish(Object payload, String exchange, String routingKey) {
        log.info("Publishing to {} using routing key {}. Payload: {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published to {} using routing key {}. Payload: {}", exchange, routingKey, payload);
    }
}
