

package com.bluedon.modules.student.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.bluedon.common.utils.Return;
import com.bluedon.modules.student.entity.StudentEntity;

/**
 * 学生服务类
 */
public interface StudentService extends IService<StudentEntity> {

    Return saveOrUpdateStu(StudentEntity entity );

    Return deleteStuById(String id);

}
