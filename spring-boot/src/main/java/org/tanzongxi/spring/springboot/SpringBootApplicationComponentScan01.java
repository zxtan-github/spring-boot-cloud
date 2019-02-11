package org.tanzongxi.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.tanzongxi.spring.springboot.controller")
@ComponentScan("org.tanzongxi.spring.springboot.swagger2.controller")
public class SpringBootApplicationComponentScan01 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationComponentScan01.class, args);
    }
}
