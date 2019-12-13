package com.bluedon.modules.student.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bluedon.common.utils.Result;
import com.bluedon.modules.student.entity.StudentEntity;
import com.bluedon.modules.student.entity.StudentVo;

import java.util.List;

/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: 学生Service
 **/
public interface StudentService extends IService<StudentEntity> {

    Result saveOrUpdateStu(StudentEntity entity);

    Result deleteStuById(String id);

    public IPage<StudentVo> selectPageVo(Integer pageNo, Integer pageSize);


    public List<StudentVo> selectList();

    public List<StudentVo> selectListByParms(StudentVo vo);
}
