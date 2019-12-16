package com.bluedon.common.constants;


/**
 * @date: 2019/12/13 10:23
 * @author: hhong
 * @description: 常量
 **/
public class  CommonConstant {

    /**
     * Server Error Code
     */
    public static final Integer BD_SERVER_ERROR_500 = 500;

    /**
     * Server Success Code
     */
    public static final Integer BD_SERVER_OK_200 = 200;

    /**
     * 访问权限认证未通过 510
     */
    public static final Integer BD_NO_AUTH_CODE = 510;

    public static final String BD_TOKEN_IS_NULL = "TOKEN_IS_NULL";

    public static final String BD_ERROR_TOKEN = "ERROR_TOKEN";

    //redis token key
    public static final String BD_REDIS_TOKEN_KEY = "token";

    /**
     * 状态(0无效1有效)
     */
    public static final String STATUS_0 = "0";

    public static final String STATUS_1 = "1";


    /**
     * 删除失败
     */
    public static final String DELETE_SUCCESS = "删除成功";

    /**
     * 删除失败
     */
    public static final String DELETE_FAILURE = "删除失败";

    /**
     * 保存失败
     */
    public static final String SAVE_SUCCESS = "保存成功";
    /**
     * 保存失败
     */
    public static final String SAVE_FAILURE = "保存失败";

    /**
     * 校验失败
     */
    public static final String VALIDATOR_FAILURE = "校验失败";

}
