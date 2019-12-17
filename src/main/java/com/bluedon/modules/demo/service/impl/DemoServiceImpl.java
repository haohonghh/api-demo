package com.bluedon.modules.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bluedon.common.constants.CommonConstant;
import com.bluedon.common.utils.Result;
import com.bluedon.modules.demo.dao.DemoDao;
import com.bluedon.modules.demo.entity.DemoEntity;
import com.bluedon.modules.demo.entity.DemoVo;
import com.bluedon.modules.demo.service.DemoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: 学生Service实现类
 **/
@Service("demoService")
public class DemoServiceImpl extends ServiceImpl<DemoDao, DemoEntity> implements DemoService {


    @Override
    public Result saveOrUpdateStu(DemoEntity entity) {
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
    public Result deleteDemoById(String id) {
        return this.baseMapper.deleteById(id) == 1 ? Result.ok(CommonConstant.DELETE_SUCCESS) : Result.error(CommonConstant.DELETE_FAILURE);
    }

    @Override
    public IPage<DemoVo> selectPageVo(Integer pageNo, Integer pageSize) {
        Page<DemoVo> page = new Page<>(pageNo, pageSize);
        return this.baseMapper.selectPageVo(page);
    }

    @Override
    public List<DemoVo> selectList() {
        return this.baseMapper.selectList();
    }

    @Override
    public List<DemoVo> selectListByParms(DemoVo vo) {
        return this.baseMapper.selectListByParms(vo);
    }


}
