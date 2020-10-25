package org.tanzongxi.spring.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * kafka生产者发生消息-异步async(异步回调)
 *
 * @author tanzongxi [tanzongxi@ifunq.com]
 * @date 2020/10/11 8:22
 */
public class KafkaSimpleProducerTest03 {
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
            producer.send(record, (recordMetadata, exception) -> {
                // recordMetadata和exception不会同时有值
                // recordMetadata有值表示发送成功，并获得了改消息分区元数据信息
                if (recordMetadata != null)
                    System.out.println("partition:" + recordMetadata.partition() + ",offset:" + recordMetadata.offset());
                // exception有值表示发送异常，异常信息
                if (exception != null) System.out.println(exception.getMessage());

            });
        }
        // 4 关闭连接
        producer.close();

    }
}
