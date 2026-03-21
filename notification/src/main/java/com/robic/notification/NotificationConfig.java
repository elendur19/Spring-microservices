package com.robic.notification;

import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class NotificationConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queues.notification}")
    private String notificationQueue;


    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(internalExchange);
    }
    @Bean
    public Queue notificationQueueBean() {
        return new Queue(notificationQueue);
    }

    @Bean
    public Binding internalToNotificationBinding(
            Queue notificationQueueBean,
            TopicExchange internalTopicExchange
    ) {
        return BindingBuilder
                .bind(notificationQueueBean)
                .to(internalTopicExchange)
                .with(internalNotificationRoutingKey);
    }
}
