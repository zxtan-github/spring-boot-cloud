package org.tanzongxi.spring.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * 最简单kafka消费者接受消息示例
 *
 * @author tanzongxi [tanzongxi@ifunq.com]
 * @date 2020/10/11 8:31
 */
public class KafkaSimpleConsumerrTest01 {
    public static void main(String[] args) {
        // 1 构建参数和消费者
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.253.138:9091");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put("partition.assignment.strategy", "org.xxx.xxx.ABC");
        KafkaConsumer consumer = new KafkaConsumer(properties);
        consumer.subscribe(Collections.singleton("test01"));
        consumer.poll(Duration.ofSeconds(3));

        consumer.close();
    }
}
