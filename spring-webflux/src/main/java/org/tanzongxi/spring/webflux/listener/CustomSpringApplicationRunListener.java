package org.tanzongxi.spring.webflux.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class CustomSpringApplicationRunListener implements SpringApplicationRunListener {

    public CustomSpringApplicationRunListener(SpringApplication application, String[] args) {
        // nothing
    }

    @Override
    public void starting() {
        System.out.println("CustomSpringApplicationRunListener ---> starting");

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("CustomSpringApplicationRunListener ---> environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("CustomSpringApplicationRunListener ---> contextPrepared");
    }
}
