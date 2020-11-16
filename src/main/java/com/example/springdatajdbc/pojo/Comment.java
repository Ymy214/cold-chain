package com.example.springdatajdbc.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("评论表实体类")
public class Comment {

    @ApiModelProperty("评论id")
    private int id;
    @ApiModelProperty("评论内容")
    private String comment;
    @ApiModelProperty("学生")
    private int student_id;
    @ApiModelProperty("课程id")
    private int course_id;


}
