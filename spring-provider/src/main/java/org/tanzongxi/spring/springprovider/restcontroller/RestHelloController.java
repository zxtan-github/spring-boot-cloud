package org.tanzongxi.spring.springprovider.restcontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHelloController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("/helloCloud")
    public String helloCloud() {
        System.out.printf("helloCloud: " + port);
        return "helloCloud: " + port;
    }
}
