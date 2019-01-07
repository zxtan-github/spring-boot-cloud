//package org.tanzongxi.spring.springboot.stream;
//
//
////SinkSender  接口在SinkReceiver  已经进行过绑定了
//
//import org.springframework.cloud.stream.annotation.Input;
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.SubscribableChannel;
//
//public interface SinkSender {
//
//    @Input("exchangeName2") // input通道输出
//    SubscribableChannel output();
//
//    @Input("input123") // input通道输出
//    SubscribableChannel sss();
//
//    @Output("input123") // input2通道输出,测试直接注解 @HelloApplicationTest2
//    MessageChannel output2();
//
//}
//
