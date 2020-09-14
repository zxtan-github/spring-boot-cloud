package org.tanzongxi.spring.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebfluxApplication {
    public static void main(String[] args) {
        String[] params = {"--server.port=9999"};
        SpringApplication.run(WebfluxApplication.class, params);
    }
}
