package org.tanzongxi.spring.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ErrorRestController {

    @RequestMapping(value = "/error/{code}")
    public Map<String, Object> error(@PathVariable int code) {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        switch (code) {
            case 404:
                objectMap.put("errorCode", "404");
                objectMap.put("errorMsg", "找不到页面");
                break;
            case 500:
                objectMap.put("errorCode", "500");
                objectMap.put("errorMsg", "系统异常");
                break;
        }
        return objectMap;
    }

}
