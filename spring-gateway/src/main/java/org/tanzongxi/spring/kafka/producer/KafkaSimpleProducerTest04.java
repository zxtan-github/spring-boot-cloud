package org.tanzongxi.spring.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.tanzongxi.spring.kafka.custom.KafkaCustomSerializer;
import org.tanzongxi.spring.kafka.custom.KafkaUser;

import java.util.Properties;

/**
 * kafka生产者发生消息-自定义序列化器
 *
 * @author tanzongxi [tanzongxi@ifunq.com]
 * @date 2020/10/11 8:22
 */
public class KafkaSimpleProducerTest04 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.253.138:9091");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // value配置自定义序列化器
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaCustomSerializer.class.getName());
        KafkaProducer producer = new KafkaProducer(properties);
        for (int i = 0; i < 5; i++) {
            ProducerRecord record = new ProducerRecord("test09", new KafkaUser("tanzongxi", "male",10+i));
            producer.send(record);
        }
        producer.close();

    }
}
