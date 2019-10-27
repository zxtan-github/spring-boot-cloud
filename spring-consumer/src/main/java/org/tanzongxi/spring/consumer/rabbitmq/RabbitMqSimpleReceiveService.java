package org.tanzongxi.spring.consumer.rabbitmq;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqSimpleReceiveService {

    @RabbitListener(queues = {"hello"})
    @RabbitHandler
    public void process(@Payload String msg) {
        System.out.println("====================================="+msg+"=====================================");
    }

}
