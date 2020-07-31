package org.tanzongxi.spring.nacos.consumer.restcontroller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class RestNacosConsumerController {

    @Resource
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/helloNacos/{name}", method = RequestMethod.GET)
    public String echo(@PathVariable String name) {
        return restTemplate.getForObject("http://nacos-provider-service/helloNacos/" + name, String.class);
    }


    @GetMapping("/ncport")
    public String getNcportInfo() {
        String configInfo = "";
        try {
            ConfigService configService = NacosFactory.createConfigService("192.168.253.1:8848");
            configInfo = configService.getConfig("com.sfebiz.logistics.common.dynamicConfig.port.provider.NCPORT", "HAITAO", 3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return configInfo;
    }


}

@RestController
@RefreshScope
class NacosConfigInfo {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
