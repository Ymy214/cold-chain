package com.example.springdatajdbc.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("管理员")
public class Admin {

    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("电话")
    private  String tel;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("性别")
    private  String sex;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("头像")
    private String icon;
    @ApiModelProperty("是否冻结")
    private int isfreeze;

}
