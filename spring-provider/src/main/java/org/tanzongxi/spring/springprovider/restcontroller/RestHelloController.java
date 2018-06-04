package org.tanzongxi.spring.springprovider.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHelloController {

    @RequestMapping("/helloCloud")
    public String helloCloud() {
        return "helloCloud";
    }
}
