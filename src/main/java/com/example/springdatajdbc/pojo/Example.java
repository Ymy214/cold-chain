package com.example.springdatajdbc.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("题目表实例")
public class Example {

    @Version
    @TableId(type = IdType.AUTO)
    private Long id;
    private String example;
    private String solution;
    //自动添加填充字段--不需要修改数据库字段的的默认值了-当你不能修改公司数据库的时候，你可以使用自动填充
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //yml全局配置的逻辑删除字段名是deleted，所以字段只要是deleted就不用加注解@TableLogic
    //但是所有的大前提是数据库含有相关字段，且与实体类配置一直，
    private Integer deleted;

}
