package com.bluedon.modules.student.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bluedon.common.utils.Return;
import com.bluedon.modules.student.dao.StudentDao;
import com.bluedon.modules.student.entity.StudentEntity;
import com.bluedon.modules.student.service.StudentService;
import org.springframework.stereotype.Service;


@Service("studentService")
public class UserServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {


    @Override
    public Return saveOrUpdateStu(StudentEntity entity) {
        String id = entity.getId();
        int i =0;
        if (id!=null&&!"".equals(id)){
             i = this.baseMapper.updateById(entity);
        }else{
            i =this.baseMapper.insert(entity);
        }

        return i ==1?Return.success():Return.error();
    }

    @Override
    public Return deleteStuById(String id) {
        return this.baseMapper.deleteById(id) ==1?Return.success():Return.error();
    }
}
