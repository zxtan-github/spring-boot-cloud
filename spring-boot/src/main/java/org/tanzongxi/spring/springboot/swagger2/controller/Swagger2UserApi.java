package org.tanzongxi.spring.springboot.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api("用户信息管理API")
@RequestMapping("/userApi/*")
public interface Swagger2UserApi {

    @ApiOperation("获取列表")
    @GetMapping("list")
    public List userList();
}
