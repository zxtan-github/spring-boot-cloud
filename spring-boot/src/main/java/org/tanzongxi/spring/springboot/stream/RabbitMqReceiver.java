package org.tanzongxi.spring.springboot.stream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class RabbitMqReceiver {

    private static Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receiveMsg(Object msg) {
        System.out.println(msg);
        logger.info("receive : " + msg);
    }
}
