package org.tanzongxi.spring.oauth2.authorize.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Oauth2AuthorizeServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthorizeServerApplication.class, args);
    }
}
