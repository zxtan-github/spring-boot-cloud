package org.tanzongxi.spring.springprovider.restcontroller;

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
    private MessageChannel mqScoreOutput;

    @RequestMapping("/rabbitSendMsg")
    public String helloCloud() {
        Message<String> fffff = MessageBuilder.withPayload("fffffsend1").build();
        sendChannel.scoreOutput().send(fffff);
        System.out.println("发送消息send1");
        return "success";
    }
}
