package org.tanzongxi.spring.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.tanzongxi.spring.kafka.custom.KafkaCustomPartitioner;
import org.tanzongxi.spring.kafka.custom.KafkaCustomSerializer;
import org.tanzongxi.spring.kafka.custom.KafkaUser;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * kafka生产者发生消息-自定义分区器
 *
 * @author tanzongxi [tanzongxi@ifunq.com]
 * @date 2020/10/11 10:37
 */
public class KafkaSimpleProducerTest05 {
    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.253.138:9091");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer producer = new KafkaProducer(properties);
        for (int i = 0; i < 10; i++) {
            ProducerRecord record = new ProducerRecord("test01", "KafkaSimpleProducerTest05-" + i);
            // 消息始终发往第一个分区
            producer.send(record, (recordMetadata, exception) -> {
                System.out.println("partition:" + recordMetadata.partition() + ",offset:" + recordMetadata.offset());
            });
            TimeUnit.SECONDS.sleep(1);
        }
        producer.close();

    }
}
