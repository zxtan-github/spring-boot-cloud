package org.tanzongxi.spring.kafka.custom;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;

public class KafkaCustomPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value,
                         byte[] valueBytes, Cluster cluster) {
        // 获取对应topic的所有分区信息
        List<PartitionInfo> partitionInfos = cluster.partitionsForTopic("test01");
        // 始终返回第一个分区
        // return partitionInfos.get(0).partition();
        // 或者直接返回0
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
