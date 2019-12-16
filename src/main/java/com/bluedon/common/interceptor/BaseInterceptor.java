package com.bluedon.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.bluedon.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

/**
 * @date: 2019/12/10 16:23
 * @author: hhong
 * @description: 自定义拦截器基类
 **/
@Slf4j
public abstract class BaseInterceptor extends HandlerInterceptorAdapter {


    public void setResponse(HttpServletRequest request, HttpServletResponse response, Result result) {

        response.setContentType("application/json;charset=UTF-8");
        try (Writer writer = response.getWriter()) {
            logger(request, result);
            JSON.writeJSONString(writer, result);
            writer.flush();
        } catch (IOException e) {
            log.error("respose 设置操作异常：" + e);
        }
    }


    /**
     * 日志打印
     */
    private void logger(HttpServletRequest request, Result result) {
        StringBuffer msg = new StringBuffer();
        msg.append("异常拦截日志:");
        msg.append("[uri:").append(request.getRequestURI()).append("]");
        Enumeration<String> enumer = request.getParameterNames();
        while (enumer.hasMoreElements()) {
            String name = enumer.nextElement();
            String[] values = request.getParameterValues(name);
            msg.append("[").append(name).append("=");
            if (values != null) {
                int i = 0;
                for (String value : values) {
                    i++;
                    msg.append(value);
                    if (i < values.length) {
                        msg.append("｜");
                    }
                }
            }
            msg.append("]");
        }
        msg.append(JSON.toJSONString(result));

        log.warn(msg.toString());
    }
}

