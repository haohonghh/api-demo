package com.bluedon.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 校验错误拦截处理
 */
@Slf4j
@RestControllerAdvice
public class RRExceptionHandler {

    /**
     * 校验错误拦截处理
     *
     * @param e 错误信息集合
     * @return 错误信息
     */
    @ExceptionHandler(RRException.class)
    public Object handle(RRException e) {
        return e.getR();
    }
}