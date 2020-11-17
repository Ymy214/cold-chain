package com.example.springdatajdbc.service.impl;

import com.example.springdatajdbc.mapper.CourseMapper;
import com.example.springdatajdbc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;


    @Override
    public boolean count() {
        return courseMapper.count();
    }
}
