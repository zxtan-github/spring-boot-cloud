package org.tanzongxi.spring.kafka.custom;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.common.serialization.Serializer;

public class KafkaCustomSerializer implements Serializer<KafkaUser> {
    @Override
    public byte[] serialize(String s, KafkaUser o) {
        return JSONObject.toJSONBytes(o);
    }
}
