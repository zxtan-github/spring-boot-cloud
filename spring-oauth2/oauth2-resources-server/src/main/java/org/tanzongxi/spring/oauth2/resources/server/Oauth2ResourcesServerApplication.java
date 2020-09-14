package org.tanzongxi.spring.oauth2.resources.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class Oauth2ResourcesServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2ResourcesServerApplication.class, args);
    }

    // 资源API
    @GetMapping("/api/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }

    // 资源API
    @RequestMapping("/api/getCurrentUserEmail")
    public String getCurrentUserEmail() {
        String  user  = (String) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String email = user+ "@test.com";
        return email;
    }

}
