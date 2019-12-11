package com.bluedon.common.constants;

public interface CommonConstant {

    /**
     * Server Error Code
     */
    public static final Integer BD_SERVER_ERROR_500 = 500;

    /**
     * Server Success Code
     */
    public static final Integer BD_SERVER_OK_200 = 200;
    
    /**访问权限认证未通过 510*/
    public static final Integer BD_JEECG_NO_AUTHZ=510;

    public static final String BD_TOKEN_IS_NULL="TOKEN_IS_NULL";

    /**
     * 状态(0无效1有效)
     */
    public static final String STATUS_0 = "0";

    public static final String STATUS_1 = "1";


    /**
     * 删除失败
     */
    public static final String DELETE_FAILURE = "删除失败";

    /**
     * 保存失败
     */
    public static final String SAVE_FAILURE = "保存失败";

    /**
     * 校验失败
     */
    public static final String VALIDATOR_FAILURE = "校验失败";

}
