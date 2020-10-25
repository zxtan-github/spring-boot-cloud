package org.tanzongxi.spring.kafka.producer;

import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.tanzongxi.spring.kafka.custom.KafkaCustomProducerInterceptor;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * kafka生产者发生消息-自定义生产者拦截器
 *
 * @author tanzongxi [tanzongxi@ifunq.com]
 * @date 2020/10/11 11:01
 */
public class KafkaSimpleProducerTest06 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.253.138:9091");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put("interceptor.classes", KafkaCustomProducerInterceptor.class.getName());
        KafkaProducer producer = new KafkaProducer(properties);
        for (int i = 0; i < 5; i++) {
            ProducerRecord record = new ProducerRecord("test01", "KafkaSimpleProducerTest06-" + i);
            producer.send(record);

        }
        producer.close();

    }
}
