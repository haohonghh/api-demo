package com.bluedon.common.interceptor;

import com.bluedon.common.annotation.DisableAuth;
import com.bluedon.common.constants.CommonConstant;
import com.bluedon.common.exception.BDException;
import com.bluedon.common.utils.IPUtil;
import com.bluedon.common.utils.RedisUtil;
import com.bluedon.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date: 2019/12/10 15:23
 * @author: hhong
 * @description: 自定义token过滤拦截器
 **/
@Slf4j
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //1、如有有放行注解则不需要token，直接放行
        HandlerMethod method = (HandlerMethod) handler;
        DisableAuth auth = method.getMethod().getAnnotation(DisableAuth.class);
        if (isDisableAuth(auth)) {
            return super.preHandle(request, response, handler);
        }
        //2、没有放行注解的话，前端要带token参数才能访问相关接口，
        String accessToken = getAuthToken(request);
        // token为空，直接拦截返回
        if (StringUtils.isBlank(accessToken)) {
            throw new BDException(Result.error(CommonConstant.BD_NO_AUTH_CODE, CommonConstant.BD_TOKEN_IS_NULL));
        }

        // 3.判断token是否正确
        String clientIp = IPUtil.getIP(request);
        log.info("request ip>>>>>>>>>>" + clientIp);
        String token = redisUtil.hget(CommonConstant.BD_REDIS_TOKEN_KEY, clientIp);
        if (StringUtils.isEmpty(token) || !token.equals(accessToken)) {
            throw new BDException(Result.error(CommonConstant.BD_NO_AUTH_CODE, CommonConstant.BD_TOKEN_IS_ERROR));
        }

        return true;
    }

    private static boolean isDisableAuth(DisableAuth auth) {
        return auth != null;
    }

    /**
     * 获取http请求头部或者参数中的token值
     *
     * @param request http请求传递的值
     * @return 返回token
     */
    private String getAuthToken(HttpServletRequest request) {
        String token = request.getHeader(CommonConstant.BD_REDIS_TOKEN_KEY);

        if (token == null) {
            token = request.getParameter(CommonConstant.BD_REDIS_TOKEN_KEY);
        }
        return token;
    }
}
