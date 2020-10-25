package org.tanzongxi.spring.kafka.custom;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.common.serialization.Deserializer;

public class KafkaCustomDeserializer implements Deserializer<KafkaUser> {
    @Override
    public KafkaUser deserialize(String s, byte[] bytes) {
        return JSONObject.parseObject(bytes, KafkaUser.class);
    }
}
