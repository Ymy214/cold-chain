package com.example.springdatajdbc.mapper;

import com.example.springdatajdbc.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    //获取所有部门信息
    List<Dept> getAllDept();

    //根据id获取部门信息
    Dept getDept(Integer id);




}
