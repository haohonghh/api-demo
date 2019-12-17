package com.bluedon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.bluedon.module.*.dao")
public class BluedonApplication {

    public static void main(String[] args) {
        SpringApplication.run(BluedonApplication.class, args);
    }

}
