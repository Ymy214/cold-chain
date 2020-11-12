package com.example.springdatajdbc.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("部门实体类")
public class Dept {

    @ApiModelProperty(value = "部门编号", example = "123")
    private Integer id;
    @ApiModelProperty("部门名字")
    private String deptName;

}
