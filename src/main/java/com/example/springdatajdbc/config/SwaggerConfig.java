package com.example.springdatajdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2  //open
public class SwaggerConfig {

    @Bean  //配置docket来配置swagger具体参数
    public Docket docket(Environment env) {
        //设置要显示swagger的环境，设定dev和test黄静要显示swagger
        Profiles of = Profiles.of("dev", "test");
        //判断当前环境是否处于dev or test环境
        boolean b = env.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(b)  //是否启用swagger，false代表不启用，浏览器也无法访问
                .groupName("殷名洋-SaaS平台三部")  //配置分组名字
                .select()  //通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.example.springdatajdbc.controller"))
                //.paths(PathSelectors.ant("/dept/**"))  //只扫描请求以/api开头的接口,PathSelectors.any(全部扫描).none(都不扫描)
                .build();

    }

    //协同开发，其他成员，每人一个
    /*

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("成员1-SaaS平台三部");
    }
    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("成员2-SaaS平台三部");
    }
    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("成员3-SaaS平台三部");
    }

     */

    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("殷名洋", "https://cnblogs.com/runtu/", "yinmingyang@zhongruigroup.com");
        return new ApiInfo(
                "冷链物流项目组系统后端API文档",
                "守护心底小小少年",
                "v1.0",
                "http://gitlab.lunuz.cn",
                contact,
                "Apache 2.0 开源许可",
                "许可链接url",
                new ArrayList<>()  //扩展
        );


    }

}
