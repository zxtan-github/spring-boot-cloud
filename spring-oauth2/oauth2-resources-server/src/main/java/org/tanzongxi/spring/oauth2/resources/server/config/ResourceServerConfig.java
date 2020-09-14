//package org.tanzongxi.spring.oauth2.resources.server.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
///**
// * 资源服务器配置
// * 添加资源服务器配置，使用@EnableResourceServer注解开启
// *
// * @author tanzongxi [tanzongxi@ifunq.com]
// * @date 2020/7/23 16:03
// */
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .requestMatchers()
//                .antMatchers("/user/**", "/api/**");//配置需要保护的资源路径
//
////        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
////                .and()
////                .authorizeRequests().anyRequest().permitAll();
//    }
//
//    /**
//     * Bean模式创建RemoteTokenService，可以不配置security.oauth2.resource.token-info-uri
//     */
////    @Primary
////    @Bean
////    public RemoteTokenServices tokenServices() {
////        final RemoteTokenServices tokenService = new RemoteTokenServices();
////        tokenService.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
////        tokenService.setClientId("testclientid");
////        tokenService.setClientSecret("1234");
////        return tokenService;
////    }
//}
