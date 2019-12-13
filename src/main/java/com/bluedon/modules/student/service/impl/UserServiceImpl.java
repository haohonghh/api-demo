package com.bluedon.modules.student.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bluedon.common.constants.CommonConstant;
import com.bluedon.common.utils.Result;
import com.bluedon.modules.student.dao.StudentDao;
import com.bluedon.modules.student.entity.StudentEntity;
import com.bluedon.modules.student.entity.StudentVo;
import com.bluedon.modules.student.service.StudentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: 学生Service实现类
 **/
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

        return i == 1 ? Result.ok(CommonConstant.SAVE_SUCCESS) : Result.error(CommonConstant.SAVE_FAILURE);
    }

    @Override
    public Result deleteStuById(String id) {
        return this.baseMapper.deleteById(id) == 1 ? Result.ok(CommonConstant.DELETE_SUCCESS) : Result.error(CommonConstant.DELETE_FAILURE);
    }

    @Override
    public IPage<StudentVo> selectPageVo(Integer pageNo, Integer pageSize) {
        Page<StudentVo> page = new Page<>(pageNo, pageSize);
        return this.baseMapper.selectPageVo(page);
    }

    @Override
    public List<StudentVo> selectList() {
        return this.baseMapper.selectList();
    }

    @Override
    public List<StudentVo> selectListByParms(StudentVo vo) {
        return this.baseMapper.selectListByParms(vo);
    }


}
