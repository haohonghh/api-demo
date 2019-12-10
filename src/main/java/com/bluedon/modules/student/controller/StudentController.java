package com.bluedon.modules.student.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bluedon.common.annotation.DisableAuth;
import com.bluedon.common.utils.Return;
import com.bluedon.modules.student.entity.StudentEntity;
import com.bluedon.modules.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: 增删改查demo
 **/
@RestController
@RequestMapping("/student")
@Api("学生管理测试接口")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @DisableAuth
    @GetMapping("/list")
    @ApiOperation(value = "获取学生列表", notes = "获取所有学生信息")
    public Return list(@RequestParam(defaultValue = "1") Long currentPage, @RequestParam(defaultValue = "20")Long pageSize) {
        Page<StudentEntity> page = new Page<>(currentPage, pageSize);
        IPage<StudentEntity> iPage = studentService.page(page);
        return Return.success(iPage);
    }

    @DisableAuth
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取学生信息", notes = "根据id获取学生信息")
    public Return getById(@PathVariable("id") String id) {
        return Return.success(studentService.getById(id));
    }


    @PostMapping("/addOrUpdate")
    @ApiOperation(value = "添加或修改学生信息", notes = "添加或修改学生信息")
    public Return addStudent(@RequestBody @Valid @ApiParam(name="学生对象",value="传入json格式",required=true)StudentEntity entity, BindingResult result) {
        return studentService.saveOrUpdateStu(entity);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除学生信息", notes = "删除学生信息")
    public Return delStudent(@PathVariable("id") String id) {
        return studentService.deleteStuById(id);
    }

}
