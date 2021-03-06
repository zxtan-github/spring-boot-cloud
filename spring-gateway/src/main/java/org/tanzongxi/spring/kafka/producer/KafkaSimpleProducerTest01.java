package org.tanzongxi.spring.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * 最简单kafka生产者发生消息示例
 *
 * @author tanzongxi [tanzongxi@ifunq.com]
 * @date 2020/10/11 8:01
 */
public class KafkaSimpleProducerTest01 {
    public static void main(String[] args) {
        // 1 构建参数和生产者
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.253.138:9091");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer producer = new KafkaProducer(properties);

        for (int i = 0; i < 5; i++) {
            // 2 构建消息
            ProducerRecord record = new ProducerRecord("test01", "KafkaSimpleProducerTest01-" + i);
            // 3 发送消息
            producer.send(record);
        }
        // 4 关闭连接
        producer.close();

    }
}
