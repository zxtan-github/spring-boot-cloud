package org.tanzongxi.spring.consumer.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

public class MyHystrixCommand extends HystrixCommand<String> {

    public MyHystrixCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
    }
    public MyHystrixCommand(Setter setter, RestTemplate restTemplate) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyHystrixGroup")));
    }

    @Override
    protected String run() throws Exception {
        return "MyHystrixCommand";
    }


}
