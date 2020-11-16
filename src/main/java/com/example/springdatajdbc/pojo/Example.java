package com.example.springdatajdbc.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("题目表实例")
public class Example {

    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("题目")
    private String example;
    @ApiModelProperty("解答")
    private String solution;

}
