package com.example.springdatajdbc.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("部门实体类")
public class Dept {

    @ApiModelProperty("部门编号")
    private Integer id;
    @ApiModelProperty("部门名字")
    private String deptName;

}
