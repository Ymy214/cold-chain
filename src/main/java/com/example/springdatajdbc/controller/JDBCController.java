package com.example.springdatajdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc")
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    //查询所有数据
    //http://localhost:8080/jdbc/list
    @GetMapping("/list")
    public List<Map<String, Object>> studentList() {
        String sql = "select * from student";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    //新增一个用户
    //http://localhost:8080/jdbc/add
    @PostMapping("/add")
    public String addStudent() {
        //插入语句
        String sql = "INSERT INTO `moocdb`.`student`(`tel`, `email`) VALUES ('96312312353', '66226')";
        jdbcTemplate.update(sql);
        return "addOK";
    }

    //修改用户信息
    //http://localhost:8080/jdbc/update/2017005
    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") int id) {
        String sql = "UPDATE `moocdb`.`student` SET `tel` = ?, `password` = ?, `nickname` = ? WHERE `id` = "+id;
        Object[] objects = new Object[3];
        objects[0] = "1253256324";
        objects[1] = "12356893";
        objects[2] = "秦将";

        jdbcTemplate.update(sql, objects);
        return "updateOK";
    }

    //删除用户
    //http://localhost:8080/jdbc/delete/2017006
    @DeleteMapping("/delete/{id}")
    public String delStudent(@PathVariable("id") int id) {
        String sql = "DELETE FROM `moocdb`.`student` WHERE `id` = ?";
        jdbcTemplate.update(sql, id);

        return "deleteOK";
    }







}





