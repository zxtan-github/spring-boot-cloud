package org.tanzongxi.spring.springboot.stream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

// 用来指定一个或多个定义了@Input 或者 @Output注解的接口，实现对消息通道的绑定。Sink接口是默认输入消息通道绑定接口
@EnableBinding(SinkSender.class)
public class RabbitMqReceiver {

    private static Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);


    //将被修饰的方法注册为消息中间件上数据流的事件监听器
//    @StreamListener("input123")
//    public void receiveMsg2(Message<String> message) {
//        System.out.println("Received：" + message.getPayload());
//        logger.info("Received: " + message);
//    }

    //将被修饰的方法注册为消息中间件上数据流的事件监听器
    @StreamListener("exchangeName2")
    public void receiveMsg(Message<String> message) {
        System.out.println("Received：" + message.getPayload());
        logger.info("Received: " + message);
    }

//
//    @Autowired
//    private MessageChannel input123;
}
