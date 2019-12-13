package com.bluedon.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * 测试如何优雅读取自定义配置文件
 */
@PropertySource(value = {"classpath:weixinpay.properties"})
@ConfigurationProperties(prefix = "weixinpay")
@Component
@Data
public class WeiXinPayConfig {
    private String appid;

    private String mch_id;

    private String sign_key;


}
