package com.example.springdatajdbc.controller;

import com.example.springdatajdbc.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swag-api")
public class HelloController {

    @ApiOperation("说你好")
    @GetMapping("/say-hi")
    public String sayHi() {
        return "hello swagger say hi";
    }

    @ApiOperation("简单获取一个User对象")
    @GetMapping("/get-user")
    public User getAUser() {
        return new User();
    }

    @ApiOperation("简单获取一个User对象")
    @GetMapping("/hello1")
    public User hello1() {
        return new User();
    }

    @ApiOperation("简单获取一个User对象")
    @PostMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username) {
        return "hello" + username;
    }



}

