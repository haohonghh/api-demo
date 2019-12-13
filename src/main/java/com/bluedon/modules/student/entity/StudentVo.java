package com.bluedon.modules.student.entity;

import lombok.Data;

/**
 * @date: 2019/12/13 16:26
 * @author: hhong
 * @name:
 * @description:
 **/
@Data
public class StudentVo {

    private static final long serialVersionUID = 1L;

    private String id;

    private int age;

    private String password;

    private String userName;

    private String className;

    private String classNo;
}
