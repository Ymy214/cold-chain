package com.example.springdatajdbc.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springdatajdbc.utils.JwtNeedToken;
import com.example.springdatajdbc.utils.JwtUtil;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TestJwtController {

    /**
     * 登录并获取token
     */
    @GetMapping("/token")
    public Object login(String ak, String sk) {
        JSONObject jo=new JSONObject();
        // 检验用户是否存在(为了简单，这里假设用户存在，并制造一个uuid假设为用户id)
        String uid = UUID.randomUUID().toString();
        // 生成签名
        String token= JwtUtil.sign(uid);
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("access_key", ak);
        userInfo.put("secret_key", sk);
        jo.put("token", token);
        jo.put("user", userInfo);
        return jo;
    }

    /**
     * 该接口需要带签名才能访问
     * header带着token访问即可
     */
    @JwtNeedToken
    @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "token", required = true)
    @PostMapping("/msg")
    public String getMessage(){
        return "你已通过token验证";
    }
}
