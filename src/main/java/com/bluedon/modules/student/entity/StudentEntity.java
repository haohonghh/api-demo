package com.bluedon.modules.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: 学生对象
 **/
@Data
@TableName("t_student")
@ApiModel(value = "student对象", description = "用户对象student")
public class StudentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.UUID)
    @ApiModelProperty(value = "id", name = "id", example = "cc8b4c08a511aa101bae5d38ar1a6326")
    private String id;

    @Max(value = 60, message = "年龄输入不能大于60")
    @Min(value = 18, message = "年龄输入不能小于18")
    @ApiModelProperty(value = "年龄", name = "age", example = "20")
    private int age;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", name = "password", example = "pwd123", required = true)
    private String password;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", name = "userName", example = "hhong", required = true)
    private String userName;

    @ApiModelProperty(value = "班级id", name = "classesId", example = "cc8b4c08a511aa101bae5d38ar1a6326")
    private String classesId;

}
