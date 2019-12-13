package com.bluedon.zidingyi_config;

import com.bluedon.config.WeiXinPayConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @date: 2019/12/13 14:39
 * @author: hhong
 * @name:
 * @description: 读取自定义properteis文件测试
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadConfigTest {

    @Autowired
    private WeiXinPayConfig weiXinPayConfig;

    @Test
    public void contextLoads() {
        System.out.println(weiXinPayConfig);
        System.out.println(weiXinPayConfig.getAppid());
        System.out.println(weiXinPayConfig.getMch_id());
        System.out.println(weiXinPayConfig.getSign_key());
    }

}
