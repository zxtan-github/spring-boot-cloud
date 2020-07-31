package org.tanzongxi.spring.oauth2.authorize.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.tanzongxi.spring.oauth2.authorize.server.UserService;

/**
 * 认证服务器配置
 * 添加认证服务器配置，使用@EnableAuthorizationServer注解开启
 *
 * @author tanzongxi [tanzongxi@ifunq.com]
 * @date 2020/7/23 15:59
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("redisTokenStore")
    private TokenStore redisTokenStore;

    @Autowired
    @Qualifier("jwtTokenStore")
    private TokenStore jwtTokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private JwtTokenStoreConfig.JwtTokenEnhancer jwtTokenEnhancer;

    /**
     * 使用密码模式需要配置
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

        // 未配置令牌存储策略，默认为本机java堆内存保存，单点认证，单点故障，重启需要重新认证问题
         endpoints.authenticationManager(authenticationManager)
                 .userDetailsService(userService);


        // 配置令牌存储策略为Redis模式，分布式存储令牌，多个认证服务器统一认证，重启照样保持认证状态，无需重新认证
//        endpoints.authenticationManager(authenticationManager)
//                .userDetailsService(userService)
//                .tokenStore(redisTokenStore);


        // 配置令牌存储策略为JWT模式时，添加两个token增强器
//        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
//        List<TokenEnhancer> delegates = new ArrayList<>();
//        delegates.add(jwtTokenEnhancer); //配置JWT的内容增强器
//        delegates.add(jwtAccessTokenConverter);
//        enhancerChain.setTokenEnhancers(delegates);
//
//        // 配置令牌存储策略为jwt模式，客户端存储认证令牌，服务端解析，多个认证服务器统一认证，重启照样保持认证状态，无需重新认证
//        endpoints.authenticationManager(authenticationManager)
//                .userDetailsService(userService)
//                .tokenStore(jwtTokenStore) //配置令牌存储策略
//                .accessTokenConverter(jwtAccessTokenConverter)
//                .tokenEnhancer(enhancerChain)
//        ;
    }


    /**
     * 客户端security.oauth2.resource.jwt.key-uri中配置http://localhost:10001/oauth/token_key中去获取用户信息
     * 客户端security.oauth2.resource.token-info-uri中配置http://localhost:10001/oauth/check_token中去验证合法
     *
     * @param security
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        // permitAll表示不需要client_id和client_secret
        // isAuthenticated表示需要client_id和client_secret
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()");

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")//配置client_id
                .secret(passwordEncoder.encode("admin123456"))//配置client_secret
                .accessTokenValiditySeconds(3600)//配置访问token的有效期
                .refreshTokenValiditySeconds(864000)//配置刷新token的有效期
                // 回调地址验证，好像不配置不行，应该可以正则配置所有uri
                .redirectUris("http://www.baidu.com",
                        "http://localhost:9501/login",
                        "http://localhost:9502/login",
                        "http://localhost:9503/login",
                        "http://localhost:9504/login")//配置redirect_uri，用于授权成功后跳转
                .scopes("all")//配置申请的权限范围
                // .autoApprove(true) //自动授权配置
                .authorizedGrantTypes("authorization_code", "password", "refresh_token");//配置grant_type，表示授权类型
    }
}
