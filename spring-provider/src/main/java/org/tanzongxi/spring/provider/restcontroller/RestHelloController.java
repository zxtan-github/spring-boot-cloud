package org.tanzongxi.spring.provider.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tanzongxi.spring.provider.rabbitmq.RabbitMqSimpleSendService;

@RefreshScope
@RestController
public class RestHelloController {

    @Value("${server.port}")
    private int port;

    @Value("${envName}")
    private String envName;

    @Autowired
    RabbitMqSimpleSendService rabbitMqSimpleSendService;

    @RequestMapping("/helloCloud")
    public String helloCloud() {
        System.out.printf("helloCloud: " + port);
        return "helloCloud: " + port;
    }

    @RequestMapping("/envNameCloud")
    public String envNameCloud() {
        System.out.printf("envName: " + envName);
        return envName;
    }


    @RequestMapping("/sendHelloMsg")
    public String sendHelloMsg(String msg) {
        rabbitMqSimpleSendService.sendHelloMsg(msg);
        return "success";
    }
}
