package com.test.ems.subscriber;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitMQConsumerConfig {
    public static final String QUEUE = "employee.notifications";

    @Bean
    public Queue queueConsumer() {
        return new Queue(QUEUE, true);
    }
}
