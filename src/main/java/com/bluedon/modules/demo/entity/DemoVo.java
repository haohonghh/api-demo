package com.bluedon.modules.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @date: 2019/12/13 16:26
 * @author: hhong
 * @name:
 * @description:
 **/
@Data
@ApiModel(value = "DemoVo对象", description = "DemoVo对象")
public class DemoVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", name = "id", example = "2055444")
    private String id;

    @ApiModelProperty(value = "年龄", name = "age", example = "20")
    private int age;

    @ApiModelProperty(value = "密码", name = "password", example = "password")
    private String password;

    @ApiModelProperty(value = "用户名", name = "userName", example = "userName")
    private String userName;

    @ApiModelProperty(value = "邮箱", name = "email", example = "abcd123@qq.com")
    private String email;

    @ApiModelProperty(value = "测试名称", name = "testName", example = "testName")
    private String testName;

    @ApiModelProperty(value = "测试编号", name = "testNo", example = "testNo")
    private String testNo;
}
