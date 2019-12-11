package com.bluedon.common.constants;

public interface CommonConstant {

	/** {@code 500 Server Error} (HTTP/1.0 - RFC 1945) */
    public static final Integer SC_INTERNAL_SERVER_ERROR_500 = 500;
    /** {@code 200 OK} (HTTP/1.0 - RFC 1945) */
    public static final Integer SC_OK_200 = 200;
    
    /**访问权限认证未通过 510*/
    public static final Integer SC_JEECG_NO_AUTHZ=510;

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
