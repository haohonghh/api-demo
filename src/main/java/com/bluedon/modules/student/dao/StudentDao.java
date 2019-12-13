package com.bluedon.modules.student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bluedon.modules.student.entity.StudentEntity;
import com.bluedon.modules.student.entity.StudentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: 学生dao
 **/
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {

    /**
     * 分页多表查询demo
     *
     * @param page
     * @return
     */
    public IPage<StudentVo> selectPageVo(Page page);

    /**
     * 多表查询demo
     * @return
     */
    public List<StudentVo> selectList();

    /**
     * 多表并按条件查询
     * @return
     */
    public List<StudentVo> selectListByParms(StudentVo vo);

}
