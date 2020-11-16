package com.example.springdatajdbc.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("视频表实例")
public class Video {

    @ApiModelProperty("视频id")
    private int id;
    @ApiModelProperty("所属课程id")
    private int course_id;
    @ApiModelProperty("视频标题")
    private String title;
    @ApiModelProperty("视频分p")
    private int part;
    @ApiModelProperty("视频地址")
    private String url;

}
