

package com.bluedon.modules.student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bluedon.modules.student.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生dao
 *
 */
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {

}
