package com.bluedon.redis;

import com.bluedon.common.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @date: 2019/12/13 14:39
 * @author: hhong
 * @name:
 * @description: redis工具类测试
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClientTest {


    @Autowired
    private RedisUtil redisUtil;


    // String get/set测试
    @Test
    public void redisStrGetSet() {
        try {
            // redisUtil.set("test_key1","测试测试");
            //  redisUtil.set("test111","aaa",60);
            String val = redisUtil.get("test111");
            System.out.println(val);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

