package com.bluedon.common.annotation;

import java.lang.annotation.*;

/**
 * @date: 2019/12/10 15:23
 * @author: hhong
 * @description: 非鉴权注解，Controller使用此注解，过滤器将不拦截
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface DisableAuth {

}
