package com.bluedon.modules.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bluedon.common.utils.Result;
import com.bluedon.modules.student.entity.StudentEntity;

/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: 学生Service
 **/
public interface StudentService extends IService<StudentEntity> {

    Result saveOrUpdateStu(StudentEntity entity);

    Result deleteStuById(String id);


}
