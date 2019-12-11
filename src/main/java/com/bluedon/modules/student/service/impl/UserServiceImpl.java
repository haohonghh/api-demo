package com.bluedon.modules.student.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bluedon.common.constants.CommonConstant;
import com.bluedon.common.utils.Result;
import com.bluedon.modules.student.dao.StudentDao;
import com.bluedon.modules.student.entity.StudentEntity;
import com.bluedon.modules.student.service.StudentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;


@Service("studentService")
public class UserServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {


    @Override
    public Result saveOrUpdateStu(StudentEntity entity) {
        String id = entity.getId();
        int i = 0;
        if (StringUtils.isNotEmpty(id)) {
            i = this.baseMapper.updateById(entity);
        } else {
            i = this.baseMapper.insert(entity);
        }

        return i == 1 ? Result.ok() : Result.error(CommonConstant.DELETE_FAILURE);
    }

    @Override
    public Result deleteStuById(String id) {
        return this.baseMapper.deleteById(id) == 1 ? Result.ok() : Result.error(CommonConstant.SAVE_FAILURE);
    }
}
