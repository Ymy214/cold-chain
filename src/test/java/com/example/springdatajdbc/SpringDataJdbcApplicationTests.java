package com.example.springdatajdbc;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springdatajdbc.mapper.CourseMapper;
import com.example.springdatajdbc.mapper.ExampleMapper;
import com.example.springdatajdbc.pojo.Course;
import com.example.springdatajdbc.pojo.Example;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
class SpringDataJdbcApplicationTests {

    //DI注入数据源
    @Autowired
    HikariDataSource hikariDataSource;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ExampleMapper exampleMapper;


    @Test
    void contextLoads() throws SQLException {
        //查看默认的数据源你
        System.out.println(hikariDataSource.getClass());
        //获得链接
        Connection connection = hikariDataSource.getConnection();
        System.out.println(connection);
        System.out.println("druidDataSource 数据源最大连接数："+hikariDataSource.getMaximumPoolSize());
        System.out.println("druidDataSource 数据源初始化连接数："+hikariDataSource.getMinimumIdle());
        //关闭连接
        connection.close();

    }


    @Test
    void testRedis() {
        //操作数据
        stringRedisTemplate.opsForValue().append("msg","hello ,success redis");  //在msg后加上字符串
    }
    @Test
    void testMbp() {
        courseMapper.selectList(null).forEach(System.out::println);

    }

    @Test
    void testMbpInsert() {
        Example eg = new Example();
        eg.setExample("monda56100");
        eg.setSolution("daa215n100");

        int result = exampleMapper.insert(eg);
        System.out.println(result);


    }

    @Test
    void testMbpUpdate() {

        Example eg = new Example();
        eg.setId(8L);
        eg.setExample("ha3333ha");
        eg.setSolution("6666d66");
        exampleMapper.updateById(eg);  //根据传入对象的id来更新，1


    }

    //测试多线程下乐观锁失败
    @Test
    public void testOptLocker() {
        Example eg1 = exampleMapper.selectById(1L);
        eg1.setExample("fafgerbvv");
        eg1.setSolution("fwrvgwe212vgqer");

        Example eg2 = exampleMapper.selectById(1L);
        eg2.setExample("fa41351v243245v");
        eg2.setSolution("fwrv4134212vgq253er");
        //更新数据
        exampleMapper.updateById(eg2);

        exampleMapper.updateById(eg1);  //覆盖插队线程的值，当没有乐观锁的时候

    }
    @Test
    public void testSelect() {

        //exampleMapper.selectById(1L);
        exampleMapper.selectBatchIds(Arrays.asList(1, 2, 3)).forEach(System.out::println);

        //条件查询方法之一，map查询
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "问题3");
        map.put("age", 4123);
        exampleMapper.selectByMap(map).forEach(System.out::println);

    }

    //分页查询，比如物理分页，比如pagehelper
    @Test
    public void testPageSelect() {
        //参数1，当前页   参数2，页面大小
        courseMapper.selectPage(new Page<Course>(3, 15), null).getRecords().forEach(System.out::println);
    }

























}
