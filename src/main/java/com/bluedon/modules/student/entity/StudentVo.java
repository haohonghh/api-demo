package com.bluedon.modules.student.entity;

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
@ApiModel(value = "student对象", description = "student对象")
public class StudentVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", name = "id", example = "2055444")
    private String id;

    @ApiModelProperty(value = "年龄", name = "age", example = "20")
    private int age;

    @ApiModelProperty(value = "密码", name = "password", example = "password")
    private String password;

    @ApiModelProperty(value = "用户名", name = "userName", example = "userName")
    private String userName;

    @ApiModelProperty(value = "班级名称", name = "className", example = "className")
    private String className;

    @ApiModelProperty(value = "班级编号", name = "classNo", example = "classNo")
    private String classNo;
}
