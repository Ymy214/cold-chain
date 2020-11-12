package com.example.springdatajdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Map<String, Object> map) {
        //寻找并转发classpath:/templates/thymeleaf.html
        map.put("msg", "<h1>hello</h1>");
        map.put("users", Arrays.asList("gog", "wasabi"));
        return "thymeleaf";
    }


}
