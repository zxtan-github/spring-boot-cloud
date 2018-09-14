//package org.tanzongxi.spring.springboot.stream;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//
//@EnableBinding(value = {Sink.class, SinkSender.class}) //value参数指定绑定消息通道的接口 ，比如 Sink.class 有@Input注解的接口， SinkSender.class中有@Output注解的接口，应用启动时会实现对消息通道的绑定
//public class SinkReceiver {
//
//    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);
//
//    @StreamListener(Sink.INPUT) // "input" 通道监听
//    public void receive(Object payload) {
//        logger.info("Received: " + payload);
//
//    }
//}
//
