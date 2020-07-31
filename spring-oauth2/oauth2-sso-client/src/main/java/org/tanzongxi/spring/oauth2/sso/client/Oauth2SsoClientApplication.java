package org.tanzongxi.spring.oauth2.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 在启动类上添加@EnableOAuth2Sso注解来启用单点登录功能
 * @author tanzongxi [tanzongxi@ifunq.com]
 * @date 2020/7/27 17:57
 */
@EnableOAuth2Sso
@SpringBootApplication
@RestController
public class Oauth2SsoClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2SsoClientApplication.class, args);
    }

    @GetMapping("/user/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/user/admin")
    public Object adminAuth() {
        return "Has admin auth!";
    }

    @PreAuthorize("hasAuthority('GUEST')")
    @GetMapping("/user/guest")
    public Object guestAuth() {
        return "Has guest auth!";
    }

    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    @Order(101)
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
    }
}
