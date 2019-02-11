package org.tanzongxi.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.tanzongxi.spring.springboot.controller", "org.tanzongxi.spring.springboot.handler"})
public class SpringBootApplicationException01 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationException01.class, args);
    }
}
