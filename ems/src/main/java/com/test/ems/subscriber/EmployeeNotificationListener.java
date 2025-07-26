package com.test.ems.subscriber;

import com.test.ems.dto.EmployeeEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeNotificationListener {
    @RabbitListener(queues = RabbitMQConsumerConfig.QUEUE)
    public void handleMessage(EmployeeEvent event) {
        System.out.println("Notification received: " + event);
    }
}
