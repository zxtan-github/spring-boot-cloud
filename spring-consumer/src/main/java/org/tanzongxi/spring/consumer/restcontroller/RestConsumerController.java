package org.tanzongxi.spring.consumer.restcontroller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class RestConsumerController {

    @Resource
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @HystrixCommand(fallbackMethod = "defaultConsumer")
    @RequestMapping("/helloCloudConsumer")
    public String helloCloudConsumer() {
        return restTemplate.getForObject("http://spring-provider/helloCloud", String.class);
    }

    public String defaultConsumer() {
        return "defaultConsumer";
    }
}
