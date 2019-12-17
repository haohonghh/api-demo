package com.bluedon.modules.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bluedon.common.annotation.DisableAuth;
import com.bluedon.common.constants.CommonConstant;
import com.bluedon.common.utils.FileUtil;
import com.bluedon.common.utils.Result;
import com.bluedon.modules.demo.entity.DemoEntity;
import com.bluedon.modules.demo.entity.DemoVo;
import com.bluedon.modules.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: 增删改查demo
 **/
@RestController
@RequestMapping("/demo")
@Api(value = "demo接口", tags = {"demo接口"})
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;


    @DisableAuth
    @ApiOperation(value = "获取demo列表", notes = "获取所有demo信息")
    @GetMapping(value = "/list")
    public Result<?> list(@ApiParam(name = "查询条件", value = "按用户名查询")String userName,@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<DemoEntity> page = new Page<>(pageNo, pageSize);
        QueryWrapper<DemoEntity> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(userName)){
            queryWrapper.eq("user_name",userName);
        }
        IPage<DemoEntity> pageList = demoService.page(page, queryWrapper);
        log.info("查询当前页：" + pageList.getCurrent());
        log.info("查询当前页数量：" + pageList.getSize());
        log.info("查询结果数量：" + pageList.getRecords().size());
        log.info("数据总数：" + pageList.getTotal());
        return Result.ok(pageList);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取demo信息", notes = "根据id获取demo信息")
    public Result getById(@PathVariable("id") String id) {
        return Result.ok(demoService.getById(id));
    }


    @PostMapping("/addOrUpdate")
    @ApiOperation(value = "添加或修改demo信息", notes = "添加或修改demo信息")
    public Result addStudent(@RequestBody @Valid @ApiParam(name = "demo对象", value = "传入json格式", required = true) DemoEntity entity, BindingResult result) {
        return demoService.saveOrUpdateStu(entity);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除demo信息", notes = "删除demo信息")
    public Result delStudent(@PathVariable("id") String id) {
        return demoService.deleteDemoById(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping(value = "/deleteBatch/{ids}")
    @ApiOperation(value = "批量删除demo", notes = "批量删除Demo")
    public Result<?> deleteBatch(@PathVariable(name = "ids") String ids) {
        boolean b = this.demoService.removeByIds(Arrays.asList(ids.split(",")));
        return b ? Result.ok(CommonConstant.DELETE_SUCCESS) : Result.error(CommonConstant.DELETE_FAILURE);
    }


    /**
     * 分页多表查询demo
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页多表查询demo", notes = "分页多表查询demo")
    @GetMapping(value = "/selectPageVo")
    public Result list1(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        IPage<DemoVo> pageList = demoService.selectPageVo(pageNo, pageSize);
        return Result.ok(pageList);
    }

    /**
     * 多表查询demo
     */
    @ApiOperation(value = "多表查询demo", notes = "多表查询demo")
    @GetMapping(value = "/selectList")
    public Result list2() {
        List<DemoVo> demoVos = demoService.selectList();
        return Result.ok(demoVos);
    }

    /**
     * 多表查询demo
     */
    @ApiOperation(value = "多表按条件查询demo", notes = "多表按条件查询demo")
    @GetMapping(value = "/selectListByParms")
    public Result selectListByParms(@ApiParam(name = "demo对象", value = "传入json格式") DemoVo vo) {
        List<DemoVo> demoVos = demoService.selectListByParms(vo);
        return Result.ok(demoVos);
    }


    @Autowired
    private FileUtil fileUtil;

    /**
     * 下载
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping("/download/**")
    public void downLoad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        fileUtil.download(request, response);
    }


    /**
     * 上传
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public Result upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return fileUtil.upload(request, response);
    }

}
