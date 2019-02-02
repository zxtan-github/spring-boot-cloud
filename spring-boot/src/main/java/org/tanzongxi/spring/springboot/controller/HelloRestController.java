package org.tanzongxi.spring.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tanzongxi.spring.springboot.entity.PersonEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableAutoConfiguration
@RestController
public class HelloRestController {

    @RequestMapping("/helloString")
    public String helloString() {
        return "success";
    }

    @RequestMapping("/helloJson")
    public Map<String, Object> helloJson() {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        objectMap.put("name", "tanzongxi");
        objectMap.put("age", 29);
        return objectMap;
    }

    @RequestMapping("/helloObject")
    public PersonEntity helloObject() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.name = "tangyan";
        personEntity.age = 21;
        return personEntity;
    }

    @RequestMapping("/helloList")
    public List<PersonEntity> helloList() {
        PersonEntity personEntity1 = new PersonEntity();
        personEntity1.name = "tanzongxi";
        personEntity1.age = 29;
        PersonEntity personEntity2 = new PersonEntity();
        personEntity2.name = "tanzongxi";
        personEntity2.age = 29;

        List<PersonEntity> personEntityList = new ArrayList<PersonEntity>();
        personEntityList.add(personEntity1);
        personEntityList.add(personEntity2);
        return personEntityList;
    }

    @RequestMapping("/helloError")
    public int helloError() {
        return 1/0;
    }

    public static void main(String[] args) {
        // 单例运行
        SpringApplication.run(HelloRestController.class, args);
    }
}
