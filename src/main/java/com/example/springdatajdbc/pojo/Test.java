package com.example.springdatajdbc.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("测验表实例")
public class Test {

    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("测验标题")
    private String title;
    @ApiModelProperty("所属课程")
    private String course_id;


}
