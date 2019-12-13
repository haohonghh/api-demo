package com.bluedon.modules.student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bluedon.modules.student.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: 学生dao
 **/
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {

}
