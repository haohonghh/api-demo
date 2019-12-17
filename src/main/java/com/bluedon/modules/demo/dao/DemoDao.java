package com.bluedon.modules.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bluedon.modules.demo.entity.DemoEntity;
import com.bluedon.modules.demo.entity.DemoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: demodao
 **/
public interface DemoDao extends BaseMapper<DemoEntity> {

    /**
     * 分页多表查询demo
     *
     * @param page
     * @return
     */
    public IPage<DemoVo> selectPageVo(Page page);

    /**
     * 多表查询demo
     *
     * @return
     */
    public List<DemoVo> selectList();

    /**
     * 多表并按条件查询
     *
     * @return
     */
    public List<DemoVo> selectListByParms(DemoVo vo);

}
