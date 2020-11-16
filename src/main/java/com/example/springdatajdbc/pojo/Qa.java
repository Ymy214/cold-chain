package com.example.springdatajdbc.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("答疑实例")
public class Qa {

    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("问题")
    private String question;
    @ApiModelProperty("答案")
    private String answer;
    @ApiModelProperty("是哪个课程的答疑")
    private int course_id;
    @ApiModelProperty("提问的学生id")
    private int student_id;
    @ApiModelProperty("答复的老师id")
    private int teacher_id;

}
