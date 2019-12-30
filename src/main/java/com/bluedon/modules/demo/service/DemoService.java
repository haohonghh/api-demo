package com.bluedon.modules.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bluedon.common.utils.Result;
import com.bluedon.modules.demo.entity.DemoEntity;
import com.bluedon.modules.demo.entity.DemoVo;

import java.util.List;

/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: DemoService
 **/
public interface DemoService extends IService<DemoEntity> {

    public Result saveOrUpdateStu(DemoEntity entity);

    public Result deleteDemoById(String id);

    public IPage<DemoVo> selectPageVo(Integer pageNo, Integer pageSize);


    public List<DemoVo> selectList();

    public List<DemoVo> selectListByParms(DemoVo vo);
}
