package org.tanzongxi.spring.springprovider.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RabbitMqSimpleSendService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendHelloMsg(String msg) {
        String hello = "Hello " + msg + " " + new Date();
        System.out.println(hello);
        amqpTemplate.convertAndSend("hello", hello);
    }

    public void sendHelloMsg() {
        String hello = "Hello " + new Date();
        System.out.println(hello);
        amqpTemplate.convertAndSend("hello", hello.getBytes());
    }

}
