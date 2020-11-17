package com.example.springdatajdbc.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springdatajdbc.service.impl.CourseServiceImpl;
import com.example.springdatajdbc.utils.JwtNeedToken;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    JSONObject jo = new JSONObject();

    @Autowired
    CourseServiceImpl courseService;

    //通用查询
    @JwtNeedToken
    @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "输入token", required = true)
    @GetMapping("/")
    public Object selectCourses() {
        jo.clear();

        //json解析
        //参数列表
        //service处理
        //生成mapper的sql语句






        jo.put("hasCount", courseService.count());

        return jo;
    }


}
