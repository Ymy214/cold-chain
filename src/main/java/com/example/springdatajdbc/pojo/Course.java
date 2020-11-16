package com.example.springdatajdbc.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("课程实体类")
public class Course {

    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("课程名字")
    private String coursename;
    @ApiModelProperty("课程类型")
    private String coursetype;
    @ApiModelProperty("课程介绍")
    private String intro;
    @ApiModelProperty("是否已删除")
    private int isdeleted;
    @ApiModelProperty("课程封面")
    private String cover;
    @ApiModelProperty("点赞数量")
    private int zan;


}
