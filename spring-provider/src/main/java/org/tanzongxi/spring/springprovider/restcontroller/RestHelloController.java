package org.tanzongxi.spring.springprovider.restcontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class RestHelloController {

    @Value("${server.port}")
    private int port;

    @Value("${envName}")
    private String envName;

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
}
