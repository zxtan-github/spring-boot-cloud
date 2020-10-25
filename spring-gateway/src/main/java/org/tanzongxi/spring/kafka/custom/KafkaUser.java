package org.tanzongxi.spring.kafka.custom;

import lombok.Data;

@Data
public class KafkaUser {
    public KafkaUser(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    private String name;
    private String sex;
    private int age;
}
