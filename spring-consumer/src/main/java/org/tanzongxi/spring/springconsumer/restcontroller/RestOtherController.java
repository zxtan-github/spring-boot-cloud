package org.tanzongxi.spring.springconsumer.restcontroller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class RestOtherController {

    @Value("${consumerName}")
    private String consumerName;

    @Resource
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultConsumer")
    @RequestMapping("/helloOtherConsumer")
    public String helloOtherConsumer() {
        return restTemplate.getForObject("http://spring-provider/helloCloud", String.class);
    }

    @HystrixCommand(fallbackMethod = "defaultConsumer")
    @RequestMapping("/hiOtherConsumer")
    public String hiOtherConsumer() {
        return restTemplate.getForObject("http://spring-provider/helloCloud", String.class);
    }

    @RequestMapping("/consumerName")
    public String consumerName() {
        return consumerName;
    }

    public String defaultConsumer() {
        return "defaultConsumer";
    }
}
