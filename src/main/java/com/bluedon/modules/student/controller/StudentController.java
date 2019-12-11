package com.bluedon.modules.student.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bluedon.common.annotation.DisableAuth;
import com.bluedon.common.constants.CommonConstant;
import com.bluedon.common.utils.FileUtil;
import com.bluedon.common.utils.Result;
import com.bluedon.modules.student.entity.StudentEntity;
import com.bluedon.modules.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;

/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: 单表增删改查demo
 **/
@RestController
@RequestMapping("/student")
@Api("学生管理测试接口")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;


    @ApiOperation(value = "获取学生列表", notes = "获取所有学生信息")
    @GetMapping(value = "/list")
    public Result<?> list(StudentEntity studentEntity, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<StudentEntity> page = new Page<>(pageNo, pageSize);
        QueryWrapper<StudentEntity> queryWrapper = new QueryWrapper<>();
        //queryWrapper.eq("id",studentEntity.getId());
        IPage<StudentEntity> pageList = studentService.page(page, queryWrapper);
        log.info("查询当前页：" + pageList.getCurrent());
        log.info("查询当前页数量：" + pageList.getSize());
        log.info("查询结果数量：" + pageList.getRecords().size());
        log.info("数据总数：" + pageList.getTotal());
        return Result.ok(pageList);
    }

    @DisableAuth
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取学生信息", notes = "根据id获取学生信息")
    public Result getById(@PathVariable("id") String id) {
        return Result.ok(studentService.getById(id));
    }


    @PostMapping("/addOrUpdate")
    @ApiOperation(value = "添加或修改学生信息", notes = "添加或修改学生信息")
    public Result addStudent(@RequestBody @Valid @ApiParam(name = "学生对象", value = "传入json格式", required = true) StudentEntity entity, BindingResult result) {
        return studentService.saveOrUpdateStu(entity);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除学生信息", notes = "删除学生信息")
    public Result delStudent(@PathVariable("id") String id) {
        return studentService.deleteStuById(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping(value = "/deleteBatch")
    @ApiOperation(value = "批量删除学生", notes = "批量删除D学生")
    public Result<?> deleteBatch(@PathVariable(name = "ids") String ids) {
        boolean b = this.studentService.removeByIds(Arrays.asList(ids.split(",")));
        return b ? Result.ok(CommonConstant.DELETE_SUCCESS) : Result.error(CommonConstant.DELETE_FAILURE);
    }

    @Autowired
    private FileUtil fileUtil;

    @GetMapping("/download/**")
    public void downLoad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        fileUtil.download(request, response);
    }


    @PostMapping("/upload")
    public Result upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return fileUtil.upload(request, response);
    }
}
