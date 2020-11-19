package com.example.springdatajdbc.config;


import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.example.*.mapper")  //扫描包,放在这里就不需要放在spring boot application了
@EnableTransactionManagement  //开启事务，默认开启
@Configuration  //配置类
public class MybatisPlusConfig {

    @Bean  //乐观锁拦截器
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    @Bean  //配置拦截器
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}

