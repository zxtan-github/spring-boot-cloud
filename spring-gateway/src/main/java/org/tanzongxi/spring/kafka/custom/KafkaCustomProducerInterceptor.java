package org.tanzongxi.spring.kafka.custom;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.header.Header;

import java.util.Date;
import java.util.Map;

/**
 * 自定义生产者拦截器
 *
 * @author tanzongxi [tanzongxi@ifunq.com]
 * @date 2020/10/11 10:55
 */
public class KafkaCustomProducerInterceptor implements ProducerInterceptor {

    // 消息发送前进行拦截的主要方法
    @Override
    public ProducerRecord onSend(ProducerRecord producerRecord) {
        // 创建一个新的消息，更改原来消息内容
        producerRecord = new ProducerRecord(producerRecord.topic(),
                "Intercepto-" + producerRecord.value());
        return producerRecord;
    }

    // 收到broker应答时回调，发送成功或者发生异常
    @Override
    public void onAcknowledgement(RecordMetadata r, Exception e) {
        // 发送消息模式中的异步async(异步回调)是一样的，r和e只有其中一个有值
        System.out.println("partition:" + r.partition() + ",offset:" + r.offset());
    }


    // producer关闭时，进行回调，可以进行一些清理工作
    @Override
    public void close() {

    }

    // 拦截器初始化时，一些准备工作，比如设定编码格式等
    @Override
    public void configure(Map<String, ?> map) {

    }
}
