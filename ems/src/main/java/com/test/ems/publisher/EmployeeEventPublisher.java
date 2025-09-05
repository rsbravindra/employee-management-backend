package com.test.ems.publisher;

import com.test.ems.config.RabbitMQConfig;
import com.test.ems.dto.EmployeeEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEventPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishEmployeeUpdate(EmployeeEvent event) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY,event);
    }

}
