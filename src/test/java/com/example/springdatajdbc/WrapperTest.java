package com.example.springdatajdbc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectOne;
import com.example.springdatajdbc.mapper.CourseMapper;
import com.example.springdatajdbc.mapper.ExampleMapper;
import com.example.springdatajdbc.pojo.Course;
import com.example.springdatajdbc.pojo.Example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private ExampleMapper exampleMapper;
    @Autowired
    private CourseMapper courseMapper;


    @Test
    void testWrapper() {
        //查询你name不为空的用户
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("coursename")
                .isNotNull("coursetype")
                .ge("zan", 50000);

        courseMapper.selectList(wrapper).forEach(System.out::println);

        wrapper.clear();
        wrapper.eq("coursename", "大学物理");
        System.out.println(courseMapper.selectOne(wrapper));

        wrapper.clear();
        wrapper.between("zan", 3000, 6000);
        //排序
        wrapper.orderByDesc("id");
        wrapper.orderByAsc("zan");
        System.out.println(courseMapper.selectCount(wrapper));


        wrapper.clear();
        wrapper
                .notLike("coursetype", "分子")
                .likeRight("coursename", "生物学");
        List<Map<String, Object>> maps = courseMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);

    }


}
