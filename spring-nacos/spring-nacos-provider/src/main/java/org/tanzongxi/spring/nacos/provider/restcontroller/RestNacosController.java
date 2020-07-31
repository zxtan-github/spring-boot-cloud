package org.tanzongxi.spring.nacos.provider.restcontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestNacosController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("/helloNacos/{name}")
    public String helloNacos(@PathVariable String name) {
        System.out.println("helloNacos(" + port + "): " + name);
        return "helloNacos(" + port + "): " + name;
    }

    @RequestMapping("/welcomeNacos/{name}")
    public String welcomeNacos(@PathVariable String name) {
        System.out.println("welcomeNacos(" + port + "): " + name);
        return "welcomeNacos(" + port + "): " + name;
    }

    @RequestMapping("/hiNacos")
    public String hiNacos(String name) {
        System.out.println("hiNacos(" + port + "): " + name);
        return "hiNacos(" + port + "): " + name;
    }


    @RequestMapping("/api/hello")
    public String hello() {
        System.out.println("hello(" + port + ")");
        return "/api/hello(" + port + ") ";
    }


    @RequestMapping("/api/user/currentUser")
    public String currentUser() {
        System.out.println("currentUser(" + port + ")");
        return "/api/user/currentUse(" + port + ")" ;
    }
}
