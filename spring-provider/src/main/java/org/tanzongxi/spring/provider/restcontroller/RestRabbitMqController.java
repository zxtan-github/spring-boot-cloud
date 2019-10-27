package org.tanzongxi.spring.provider.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(SendChannel.class)
public class RestRabbitMqController {

    @Autowired
    private SendChannel sendChannel;

    @Autowired
    private MessageChannel exchangeName2;

    @RequestMapping("/rabbitSendMsg")
    public String rabbitSendMsg(String msg) {
        Message<String> msgSend = MessageBuilder.withPayload(msg).build();
        sendChannel.scoreOutput().send(msgSend);
        System.out.println("发送消息:" + msg);
        return "success";
    }
}