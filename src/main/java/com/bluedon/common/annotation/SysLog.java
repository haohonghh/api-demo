package com.bluedon.common.annotation;

import java.lang.annotation.*;

/**
 * @date: 2019/12/13 11:23
 * @author: hhong
 * @description: 系统日志注解（暂时没用到）
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
}
