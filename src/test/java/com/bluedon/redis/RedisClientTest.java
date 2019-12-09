package com.bluedon.redis;

import com.bluedon.common.utils.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by landun on 2019/10/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClientTest {


    @Autowired
    private RedisClient redisClient;


    // String get/set测试
    @Test
    public void redisStrGetSet() {
        try {
            String strVal = redisClient.get("a");

            System.out.println("===========" + strVal);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

