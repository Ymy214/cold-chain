package com.example.springdatajdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springdatajdbc.pojo.Course;
import org.springframework.stereotype.Repository;

@Repository  //代表持久层的
public interface CourseMapper extends BaseMapper<Course> {
    //所有的crud操作基本完成，在extends了basemapper之后就已经
}
