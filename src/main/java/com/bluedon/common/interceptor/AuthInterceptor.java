package com.bluedon.common.interceptor;

import com.bluedon.common.annotation.DisableAuth;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AuthInterceptor extends BaseInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("--------authInterceptor-------");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //放行逻辑
        HandlerMethod method = (HandlerMethod) handler;
        DisableAuth auth = method.getMethod().getAnnotation(DisableAuth.class);
        if (isDisableAuth(auth)) {
            return super.preHandle(request, response, handler);
        }
        //获取token
        String accessToken = getAuthToken(request);
        if (StringUtils.isBlank(accessToken)) {
            setResponse(request, response, "ACCESS_TOKEN_IS_NULL", "Error: token is null");
            return false;
        }

        // 3.查询token是否正确
    /*    if (true) {
            setResponse(request, response, "ACCESS_TOKEN_IS_INVALID_CODE","Error: token is invalid");
            return false;
        }*/

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
        String token = request.getHeader("accessToken");

        if (token == null) {
            token = request.getParameter("accessToken");
        }
        return token;
    }
}
