package com.example.springdatajdbc.controller;

import com.example.springdatajdbc.mapper.DeptMapper;
import com.example.springdatajdbc.pojo.Dept;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptMapper deptMapper;

    @ApiOperation("查询全部部门")
    @GetMapping({"/all", "/list"})
    public List<Dept> getAllDept() {
        return deptMapper.getAllDept();
    }

    @ApiOperation("根据部门id查询部门信息")
    @GetMapping("/{id}")
    public Dept getDept(@ApiParam("部门编号") @PathVariable("id") Integer id) {
        return deptMapper.getDept(id);
    }

}
