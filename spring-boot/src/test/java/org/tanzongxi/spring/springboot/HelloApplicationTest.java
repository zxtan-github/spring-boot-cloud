package org.tanzongxi.spring.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.tanzongxi.spring.springboot.stream.SinkSender;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringConfiguration(classes = MetadataServerApplication.class)
@WebAppConfiguration
public class HelloApplicationTest {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void contextLoads() {
        //output方法注解绑定的是"input"通道
//        sinkSender.output().send(MessageBuilder.withPayload("**************From SinkSender").build());
    }

    public static void main(String[] args) {

    }
}