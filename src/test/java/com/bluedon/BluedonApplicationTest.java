package com.bluedon;

import com.alibaba.fastjson.JSON;
import com.bluedon.common.utils.SpringContextUtils;
import com.bluedon.modules.student.entity.StudentEntity;
import com.bluedon.modules.student.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @date: 2019/12/9 11:49
 * @author: hhong
 * @name:
 * @description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class BluedonApplicationTest {

    @Autowired
    private SpringContextUtils springContextUtils;


    @Test
    public void springContextUtilsTest(){
        StudentService studentService = (StudentService) springContextUtils.getBean("studentService");
        StudentEntity byId = studentService.getById("5ca8a85bdfc9b7e0903bb2f48e07b874");
        System.out.println(JSON.toJSONString(byId));
    }
}
