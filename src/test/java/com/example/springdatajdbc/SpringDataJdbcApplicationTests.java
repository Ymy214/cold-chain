package com.example.springdatajdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringDataJdbcApplicationTests {

    //DI注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //查看默认的数据源你
        System.out.println(dataSource.getClass());
        //获得链接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数："+druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数："+druidDataSource.getInitialSize());

        //关闭连接
        connection.close();

    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void testRedis() {
        //操作数据
        stringRedisTemplate.opsForValue().append("msg","hello ,success redis");  //在msg后加上字符串
    }

}
