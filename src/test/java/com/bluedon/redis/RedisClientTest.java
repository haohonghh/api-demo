package com.bluedon.redis;

//import com.bluedon.common.utils.RedisClient;
import com.bluedon.common.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by landun on 2019/10/18.
 */
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
           String val= redisUtil.get("test_key1");
           System.out.println(val);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

