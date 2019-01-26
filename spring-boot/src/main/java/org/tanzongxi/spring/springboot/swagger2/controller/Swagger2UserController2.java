package org.tanzongxi.spring.springboot.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.tanzongxi.spring.springboot.swagger2.entity.Swagger2UserEntity;

import java.util.ArrayList;
import java.util.List;

@Api("用户信息管理")
@RestController
@RequestMapping("/skk/*")
public class Swagger2UserController2 {

    private final static List<Swagger2UserEntity> userList = new ArrayList<>();

    {
        userList.add(new Swagger2UserEntity("1", "admin", "123456"));
        userList.add(new Swagger2UserEntity("2", "jacks", "111111"));
    }

    @ApiOperation("获取列表")
    @GetMapping("list")
    public List userList() {
        return userList;
    }

    @ApiOperation("新增用户")
    @PostMapping("save")
    public boolean save(Swagger2UserEntity user) {
        return userList.add(user);
    }

    @ApiOperation("更新用户")
    @ApiImplicitParam(name = "user", value = "单个用户信息", dataType = "User")
    @PutMapping("update")
    public boolean update(Swagger2UserEntity user) {
        return userList.remove(user) && userList.add(user);
    }

    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "users", value = "N个用户信息", dataType = "List<User>")
    @DeleteMapping("delete")
    public boolean delete(@RequestBody List<Swagger2UserEntity> users) {
        return userList.removeAll(users);
    }
}
