

package com.bluedon.modules.student.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.bluedon.common.utils.Result;
import com.bluedon.modules.student.entity.StudentEntity;

/**
 * 学生服务类
 */
public interface StudentService extends IService<StudentEntity> {

    Result saveOrUpdateStu(StudentEntity entity);

    Result deleteStuById(String id);

}
